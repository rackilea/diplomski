public class SetContainsBinding extends Application {
    private Parent createContent() {
        ObservableSet<Integer> numberSet = FXCollections.observableSet(1, 2, 3, 4);
        BooleanProperty contained = new SimpleBooleanProperty(this, "contained", true);
        int number = 2;
        numberSet.addListener((SetChangeListener<Integer>) c -> {
            contained.set(c.getSet().contains(number));
        });

        Circle circle = new Circle(50);
        circle.setFill(Color.RED);
        circle.visibleProperty().bind(contained);

        SetProperty<Integer> setProperty = new SimpleSetProperty<>(numberSet);
        BooleanBinding setBinding = 
                Bindings.createBooleanBinding(() -> setProperty.contains(number), setProperty);

        Circle bindingC = new Circle(50);
        bindingC.setFill(Color.BLUEVIOLET);
        bindingC.visibleProperty().bind(setBinding);

        HBox circles = new HBox(10, circle, bindingC);

        Button remove = new Button("remove");
        remove.setOnAction(e -> {
            numberSet.remove(number);
        });
        Button add = new Button("add");
        add.setOnAction(e -> {
            numberSet.add(number);
        });
        BorderPane content = new BorderPane(circles);
        content.setBottom(new HBox(10, remove, add));
        return content;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.setTitle(FXUtils.version());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("unused")
    private static final Logger LOG = Logger
            .getLogger(SetContainsBinding.class.getName());

}