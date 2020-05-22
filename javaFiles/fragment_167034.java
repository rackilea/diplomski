public class ScrollPaneSizing extends Application{

    public static class DebugScrollPaneSkin extends ScrollPaneSkin {

        public DebugScrollPaneSkin(ScrollPane scroll) {
            super(scroll);
            registerChangeListener(scroll.hbarPolicyProperty(), p -> {
                // rude .. but visibility is updated in layout anyway
                getHorizontalScrollBar().setVisible(false);
            });
        }

        @Override
        protected double computePrefHeight(double x, double topInset,
                double rightInset, double bottomInset, double leftInset) {
            double computed = super.computePrefHeight(x, topInset, rightInset, bottomInset, leftInset);
            if (getSkinnable().getHbarPolicy() == ScrollBarPolicy.AS_NEEDED && getHorizontalScrollBar().isVisible()) {
                // this is fine when horizontal bar is shown/hidden due to resizing
                // not quite okay while toggling the policy
                // the actual visibilty is updated in layoutChildren?
                computed += getHorizontalScrollBar().prefHeight(-1);
            }
            return computed;
        }


    }

    private Parent createContent() {
        HBox inner = new HBox(new Text("somehing horizontal and again again ........")); 
        TitledPane titled = new TitledPane("my title", inner);
        ScrollPane scroll = new ScrollPane(titled) {

            @Override
            protected Skin<?> createDefaultSkin() {
                return new DebugScrollPaneSkin(this);
            }

        };
        scroll.setVbarPolicy(NEVER);
        scroll.setHbarPolicy(ALWAYS);
        // scroll.setFitToHeight(true);

        Button policy = new Button("toggle HBarPolicy");
        policy.setOnAction(e -> {
            ScrollBarPolicy p = scroll.getHbarPolicy();
            scroll.setHbarPolicy(p == ALWAYS ? AS_NEEDED : ALWAYS);
        });
        HBox buttons = new HBox(10, policy);
        BorderPane content = new BorderPane();
        content.setTop(scroll);
        content.setBottom(buttons);
        return content;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent(), 400, 200));
        stage.setTitle(FXUtils.version());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("unused")
    private static final Logger LOG = Logger
            .getLogger(ScrollPaneSizing.class.getName());

}