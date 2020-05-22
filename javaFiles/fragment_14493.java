public void setWindowSize(int width, int height) {
  Lwjgl3Application app = (Lwjgl3Application) Gdx.app
  Field windowfield = app.class.getDeclaredField("currentWindow")
  if(windowfield.trySetAccessible()) {
    Lwjgl3Window window = windowfield.get(app)
    Gdx.graphics.setWindowedMode(width, height)
    // Can use context size because of no decorations on window
    window.setWindowPos(Gdx.graphics.width/2 - width/2, Gdx.graphics.height/2 - height/2)
  }
}