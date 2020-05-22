private Container<Label> container;

@Override
public void create() {
    stage=new Stage();

    Label label1 = new Label("Test text", new Label.LabelStyle(font, Color.BLACK));

    container=new Container<Label>(label1);
    container.setTransform(true);   // for enabling scaling and rotation
    container.size(100, 60);
    container.setOrigin(container.getWidth() / 2, container.getHeight() / 2);
    container.setPosition(100,200);
    container.setScale(3);  //scale according to your requirement

    stage.addActor(container);
}

@Override
public void render() {
    super.render();

    Gdx.gl.glClearColor(1,1,1,1);
    gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    stage.draw();
    stage.act();
}