@Override
public void render() {
    super.render();
    if (getScreen() != gameScreen && gameScreen != null) {
        gameScreen.dispose();
        gameScreen = null;
    }
}