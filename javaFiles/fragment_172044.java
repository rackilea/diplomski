public class YourGameClass implements Screen {
    private final TiledMap map;
    private final OrthogonalTiledMapRenderer mapRenderer;

    private final OrthographicCamera camera;

    @Override
    public void render (float delta) {
        camera.rotate(1.0f * delta);  // Rotate a little on every update (you'll want to control this a bit more)
        camera.update();
        mapRenderer.setView(camera);

        mapRenderer.render();
    }
}