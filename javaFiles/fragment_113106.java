public class Controller {

    @FXML
    private Button button ;

    public void initialize() {

        button.sceneProperty().addListener((obs, oldScene, newScene) -> {
            button.layoutYProperty().unbind();
            if (newScene != null) {
                button.layoutYProperty().bind(newScene.heightProperty().divide(2));
            }
        });

        // ...
    }
}