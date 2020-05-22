public class ChatWindow extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        stage.initStyle(StageStyle.TRANSPARENT); // here it is

        Group rg = new Group();
        Scene scene = new Scene(rg, 320, 240, Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

        Rectangle r = new Rectangle(5, 5, stage.getWidth() - 10, stage.getHeight() - 10);
        r.setFill(Color.STEELBLUE);
        r.setEffect(new DropShadow());
        rg.getChildren().add(r);
    }

    public static void main(String[] args) {
        launch();
    }
}