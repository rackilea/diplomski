public class Assets implements Disposable {

    public final Texture horse;
    public final Texture bullet;
    // etc.

    public Assets (){
        horse = new Texture("horse.png");
        //...
    }

    public void dispose(){
        horse.dispose();
        //...
    }
}

public class Zero implements Screen, InputProcessor {
    private final Assets assets;
    //...

    public Zero (){
        assets = new Assets();
        //...
    }

    //...

    public void dispose(){
        assets.dispose();
        //...
    }
}

public class Bullet {
    //...

    public void render(SpriteBatch batch, Assets assets){
         batch.render(assets.bullet, /*...*/);
    }
}