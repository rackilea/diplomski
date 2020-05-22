public class Main extends Application {
    @Override
    public void start(Stage stage) {        
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));

        final TextField textField = new TextField();
        final Button button = new Button();

        vbox.getChildren().addAll(textField, button);


        vbox.onKeyPressedProperty().set(new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent event) {
                textField.requestFocus();
            }
        });

        stage.setScene(new Scene(vbox, 300, 500));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}