public class BaseController {
    protected SceneManager sceneManager;
    void setSceneManager(SceneManager sceneManager) { // if SceneManager and BaseController are in different packages, change visibility
        this.sceneManager = sceneManager;
    }
}