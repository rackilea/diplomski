public class Main extends Application {

    private ObservableQueue<String> queue = new ObservableQueue<>(new LinkedBlockingQueue<>());

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Add to queue");
        btn.setOnAction(event -> queue.add("value"));

        Button btn2 = new Button("Remove to queue");
        btn2.setOnAction(event -> queue.remove());

        Button btn3 = new Button("Button");
        btn3.disableProperty().bind(Bindings.createBooleanBinding(queue::isEmpty, queue));

        FlowPane root = new FlowPane();
        root.getChildren().addAll(btn, btn2, btn3);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}