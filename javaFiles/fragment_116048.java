package ***;

import com.badlogic.gdx.Screen;
import ***.GameCore;

public class MyScreen implements Screen {
    GameCore game;
    public MyScreen(GameCore game) {
        this.game = game;
    }

    public GameCore getGameCore(){
        return this.game;
    }
    /*
    Methods implemented from Screen (render , hide , dispose etc...)
    */
}