Constants.VIEWPORT_WIDTH = 6;
Constants.VIEWPORT_HEIGHT = 5;
...

void init() {
    camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
    camera.position.set(Constants.VIEWPORT_WIDTH/2, Constants.VIEWPORT_HEIGHT/2, 0);
    camera.update();
}