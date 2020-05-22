public void create () {
  float w = Gdx.graphics.getWidth();
  float h = Gdx.graphics.getHeight();

  //...

  p1.setVertices(getVertices(0, 0, 20, 5));
  p2.setVertices(getVertices(0, 0, 20, 5));

  pActor pa1 = new pActor();
  pActor pa2 = new pActor();

  actors.add(pa1);
  actors.add(pa2);

  //...

  pa1.setPosition(w/2, h/2);

  //...

  pa2.setPosition(pa1.getX(), pa1.getY());

  //...

  pa2.setOrigin(pa1.getX(), pa1.getY()); // <-- This line

  //...

  drawViewportBox(w, h);
}