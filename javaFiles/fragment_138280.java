public class MyGdxGame extends Game {

    public Screen menuScreen,creditsScreen,playScreen;

    @Override
    public void create () {

        menuScreen=new MenuScreen(this);
        creditsScreen=new CreditsScreen();
        playScreen=new PlayScreen();

        setScreen(menuScreen);
    }
}