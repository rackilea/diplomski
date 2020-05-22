public class Active extends Application {

    public static Scene createScene() {
        Scene scene = //... insert your code here

        return scene;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(createScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}