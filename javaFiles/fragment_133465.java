if (Gdx.input.isButtonPressed(Buttons.LEFT))
{
  Vector3 input = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
  cam.unproject(input);
  //Now you can use input.x and input.y, as opposed to Gdx.input.getX() and
  //Gdx.input.getY(), to draw the circle
  s.drawCirc(c, input.x, input.y, 100, 100);
}