public class MultiLine extends ApplicationAdapter {

  Stage stage;

  @Override
  public void create() {

    stage=new Stage();

    RectActor rectActor=new RectActor(100,100,100,100, Color.BLACK);
    RectActor rectActor1=new RectActor(150,150,100,100, Color.BLACK);

    stage.addActor(rectActor1);
    stage.addActor(rectActor);

    rectActor.getColor().a=0;                //Make transparent
    rectActor.addAction(Actions.fadeIn(1f)); // In one second rectActor appear on Screen.
  }

  @Override
  public void render() {

    Gdx.gl.glClearColor(1,0,0,0);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    stage.draw();
    stage.act();
  }

  @Override
  public void dispose() {
      stage.dispose();
  }
}