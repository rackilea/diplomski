public class Groups implements ApplicationListener {
    private Stage stage;
    private Skin uiSkin;

    @Override public void create() {
        this.stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false);
        Gdx.input.setInputProcessor(this.stage);

        this.uiSkin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        final TextButton plainTextButton = new TextButton("Hello", this.uiSkin);
        this.stage.addActor(plainTextButton);

        final Group group = new Group();
        final TextButton groupTextButton = new TextButton("Group", this.uiSkin);
        group.addActor(groupTextButton);
        this.stage.addActor(group);

        plainTextButton.addAction(Actions.moveBy(100, 50));
        group.addAction(Actions.moveBy(50, 100));

        Gdx.gl20.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl20.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
    }

    @Override public void render() {
        this.stage.act();
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.stage.draw();
    }

    @Override public void dispose() {}
    @Override public void resize(final int width, final int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
}