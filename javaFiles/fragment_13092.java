public class MultiLine extends ApplicationAdapter {

    Stage stage;
    Skin skin;

    @Override
    public void create() {

        stage=new Stage();

        skin=new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        Label label=new Label("MULTILINE IN LIBGDX GAME DEVELOPMENT",skin);
        label.setWrap(true);

        Table table=new Table();
        table.setFillParent(true);

        table.add(label).width(150);

        stage.addActor(table);
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}