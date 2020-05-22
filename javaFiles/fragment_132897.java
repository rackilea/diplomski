public OptionScreen game_screen;

public void create() {
    FarmerAsset.load();
    game_screen = new OptionScreen(this);
    setScreen(game_screen);
}