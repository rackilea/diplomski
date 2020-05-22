public class PlayScreen implements Screen {

    private TiledMap map;
    private IsometricTiledMapRenderer isometricRenderer;
    private FitViewport viewport;

    public void createUI() {
        // Load map from tiled .tmx file.
        map = new TmxMapLoader().load("arena1/arena1.tmx");

        // Setup isometric renderer and camera.
        isometricRenderer = new IsometricTiledMapRenderer(map);

        int width = 800; // Can change to other
        int height = 480;
        viewport = new FitViewport(width, height, new OrthographicCamera(width, height));

        viewport.camera.position.set(768, 0, 0);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        isometricRenderer.setView(viewport.camera);
        isometricRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
    ...
}