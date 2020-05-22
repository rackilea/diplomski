private Camera camera;
private Viewport viewport;

public void create() {
     camera = new OrthographicCamera();
     viewport = new FitViewport(NoThanksClient.V_WIDTH, NoThanksClient.V_HEIGHT, camera);
}