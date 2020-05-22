public class MyActor extends Actor{
    Texture texture = new Texture(Gdx.files.internal("data/tex.png"));
    float actorX = 0, actorY = 0;
    public MyActor(){
        addListener(new InputListener(){//Receive events
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button){//Check your run and jump buttons
            //...
        }
    }
    @Override
    public void draw(Batch batch, float alpha){//Draw it
        batch.draw(texture,actorX,actorY);
    }
    @Override
    public void act(float delta){//Update it
    }
}