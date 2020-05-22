// ...


@Override
public void render() {
    AbstractScreen currentScreen = (AbstractScreen) getScreen();

    if (currentScreen.goBack) {
        setScreen(currentScreen.getBackScreen());
    } else if (currentScreen.goToNextScreen) {
        setScreen(currentScreen.getNextScreen());
    }
}