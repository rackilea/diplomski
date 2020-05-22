private Pixmap pixmap;
private Texture texture;

@Override
public void show() {

  float w = Gdx.graphics.getWidth();
  float h = Gdx.graphics.getHeight();

  gamecam = new OrthographicCamera(30, 30 * (h / w));
  gamecam.position.set(gamecam.viewportWidth / 2f, gamecam.viewportHeight / 2f, 0);
  gamecam.update();

  pixmap= getPixmapCircle(10, Color.WHITE,false);
  texture=new Texture(pixmap);
  texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

}

@Override
public void render() {

    Gdx.gl.glClearColor(0,0,0,1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    myGame.batch.setProjectionMatrix(gamecam.combined);
    myGame.batch.begin();
    myGame.batch.draw(texture,100,100);
    myGame.batch.end();
}

public static Pixmap getPixmapCircle(int radius, Color color, boolean isFilled) {
   Pixmap pixmap=new Pixmap(2*radius+1, 2*radius+1, Pixmap.Format.RGBA8888);
   pixmap.setColor(color);
   if(isFilled)
      pixmap.fillCircle(radius, radius, radius);
   else
      pixmap.drawCircle(radius, radius, radius);
   pixmap.drawLine(radius, radius, 2*radius, radius);
   Pixmap.setFilter(Pixmap.Filter.NearestNeighbour);
   return pixmap;
}

@Override
public void dispose() {
    pixmap.dispose();
    texture.dispose();
}