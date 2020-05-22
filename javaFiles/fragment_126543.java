...
boolean spaceIsPressed = Gdx.input.isKeyPressed(Keys.SPACE);
if (spaceIsPressed && !spaceAlreadyPressed) {
   shoot();
}
...
spaceAlreadyPressed = spaceIsPressed;