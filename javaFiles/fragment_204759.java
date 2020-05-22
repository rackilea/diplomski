public class MyController {
    private void Scene scene;
    public void setScene(Scene scene) { this.scene = scene; }

}

// loading code
FXMLLoader fxmlLoader = new FXMLLoader();
AnchorPane root = (AnchorPane) fxmlLoader.load(getClass().getResource("MyApp.fxml"));
MyController myController = (MyController) fxmlLoader.getController();
myController.setScene(scene);