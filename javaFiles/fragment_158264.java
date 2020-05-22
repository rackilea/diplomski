@Override
public void start(Stage primaryStage) {
    TextField text = new TextField();

    Button btn = new Button("Run");
    btn.setOnAction((ActionEvent event) -> {
        Task<String> task = new Task<String>() {

            @Override
            protected String call() throws Exception {
                Thread.sleep(1000);
                return "Hello World";
            }

        };
        text.textProperty().bind(task.valueProperty());
        new Thread(task).start();
    });

    VBox root = new VBox(btn, text);

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.show();
}