public class TouchButton extends Actor{
    Texture texture;
    float actorX, actorY;
    int actorWidth, actorHeight;
    public boolean started = false;
    private int buttonIndex = 0; // New stuff

    public static int lastPressIndex = 0; // New stuff/

    public TouchButton(String argButtonID, float argActorX, float argActorY, int argWidth, int argHeight, int buttonIndex){ // new parameter

        String file = argButtonID;
        texture = new Texture(Gdx.files.internal(file));
        this.actorX = argActorX;
        this.actorY = argActorY;
        this.actorWidth = argWidth;
        this.actorHeight = argHeight;
        this.buttonIndex = buttonIndex; // new stuff

        setBounds(actorX, actorY, argWidth, argHeight);
        addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                ((TouchButton)event.getTarget()).started = true;

                Gdx.app.debug("BUTTON", "pressed" );
                TouchButton.lastPressIndex = this.buttonIndex; // new stuff
                Gdx.input.vibrate(100);
                return true;
            }
        });
    }

    @Override
    public void draw(Batch batch, float alpha){
         batch.draw(texture,actorX,actorY,this.actorWidth, this.actorHeight);
    }

    @Override
    public void act(float delta){
        if(started){
            actorX+=5;
        }
    }
}