public class Screen1 implements Screen {

    Game myGame;

    public Screen1(Game myGame) {
        this.myGame = myGame;
    }

    public void changeToScreen2(){
        myGame.setScreen(new Screen2(myGame));
    }

    ...
}