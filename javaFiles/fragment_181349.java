public class TitledPaneTableScroll extends Application {

    public static class TableViewScrollSkin<T> extends TableViewSkin<T> {

        DoubleProperty hvalue = new SimpleDoubleProperty();

         public TableViewScrollSkin(TableView<T> control) {
            super(control);
            installHBarTweak();
        }

        private void installHBarTweak() {
            // Note: flow and bar could be legally retrieved via lookup 
            // protected api pre-fx9 and post-fx9
            VirtualFlow<?> flow = getVirtualFlow();
            // access scrollBar via reflection 
            // this is my personal reflective access utility method - use your own :)
            ScrollBar bar = (ScrollBar) FXUtils
                    .invokeGetFieldValue(VirtualFlow.class, flow, "hbar");
            bar.valueProperty().addListener((s, o, n) -> {
                if (n.intValue() != 0) {
                    hvalue.set(n.doubleValue());
                    // debugging
                    //  new RuntimeException("who is calling? \n").printStackTrace();
                } 
                //LOG.info("hbar value: " + n + "visible? " + bar.isVisible());
            });

            bar.visibleProperty().addListener((s, o, n) -> {
                if (n) {
                    bar.setValue(hvalue.get());
                } 
            });
        }
    }

    int counter;
    private Parent createContent() {

        TableView<Object> table = new TableView<>(FXCollections.observableArrayList(new Object()) ) {

            @Override
            protected Skin<?> createDefaultSkin() {
                return new TableViewScrollSkin<>(this);
            }

        };
        table.getColumns().addAll(Stream
                .generate(TableColumn::new)
                .limit(10)
                .map(col -> {
                    col.setPrefWidth(50);
                    col.setText("" + counter++);
                    return col;
                })
                .collect(Collectors.toList())); 


        TitledPane titled = new TitledPane("title", table);
        titled.setAnimated(true);

        BorderPane content = new BorderPane(titled);
        return content;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent(), 400, 400));
       // stage.setTitle(FXUtils.version());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("unused")
    private static final Logger LOG = Logger
            .getLogger(TitledPaneTableScroll.class.getName());

}