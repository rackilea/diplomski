public class CenterStage extends Application {
    @Override
    public void start(final Stage stage) throws Exception {
        stage.setX(300);
        stage.setWidth(800);
        stage.setHeight(400);
        stage.show();

        final Stage childStage = new Stage();
        childStage.setWidth(200);
        childStage.setHeight(200);
        childStage.setX(stage.getX() + stage.getWidth() / 2 - childStage.getWidth() / 2);
        childStage.setY(stage.getY() + stage.getHeight() / 2 - childStage.getHeight() / 2);
        childStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}