@Override
public void draw(SpriteBatch batch, float parentAlpha) {
  batch.end();
  this.render.setView((OrthographicCamera) this.getStage().getCamera());
  render.render();
  batch.begin();
}