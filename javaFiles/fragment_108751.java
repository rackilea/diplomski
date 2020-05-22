public class TestClass extends ApplicationAdapter {

    Stage stage;
    ExtendViewport extendViewport;

    @Override
    public void create() {

        extendViewport =new ExtendViewport(640,400);

        stage=new Stage(extendViewport);
        Skin skin=new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        Table scrollableTable = new Table();
        scrollableTable.setFillParent(true);
        stage.addActor(scrollableTable);

        Table table = new Table();
        table.add(new TextButton("WELCOME",skin)).row();
        table.add(new TextButton("TO",skin)).row();
        table.add(new TextButton("LIBGDX",skin)).row();
        table.add(new TextButton("GAMING",skin)).row();
        table.add(new TextButton("FRAMEWORK",skin)).row();
        table.pack();
        table.setTransform(true);  //clipping enabled

        table.setOrigin(table.getWidth()/2,table.getHeight()/2);
        table.setScale(.5f);

        final ScrollPane scroll = new ScrollPane(table, skin);
        scrollableTable.add(scroll).expand().fill();

        stage.setDebugAll(true);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height);
        stage.getCamera().position.set(320,200,0);
        stage.getCamera().update();
   }
}