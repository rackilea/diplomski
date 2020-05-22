public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            HBox root = new HBox();

            Scene scene = new Scene(root,400,400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            Label message = new Label();
            TextArea textArea = new TextArea();
            textArea.setPrefWidth(200);
            textArea.setText("message");
            message.textProperty().bind(textArea.textProperty());
            message.getStyleClass().add("rounded-background-label");

            root.getChildren().addAll(message, textArea);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}