public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        int x = 400;
        int y = 400;
        for (int i = 0; i < 5; i++) {
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(new Label("ALERT!!! ALERT!!!"), new Label("Label #:"+i));

            Stage stage  = new Stage();
            stage.setX(x);
            stage.setY(y);
            stage.setScene(new Scene(vBox));
            stage.show();

            x+=20;
            y+=20;
        }
    }
    public static void main(String[] args) { launch(args); }
}