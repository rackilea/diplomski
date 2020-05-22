public class MainChar extends Actor {

    private float showTime;
    private Animation<TextureRegion> animation;
    private boolean state = false;
    private long longCounter = 0;

    public BitmapFont font;
    public MainChar(Animation animation){

        font = new BitmapFont();
        this.animation = animation;
    }

    public void setAnimation(Animation animation){
       this.animation=animation;
    }

    float myDelta;
    @Override
    public void act(float delta){
        super.act(delta);
        myDelta = delta;
        showTime += delta;
    }

    @Override
    public void draw(Batch batch, float parentAlpha){

        super.draw(batch, parentAlpha);
        batch.draw(animation2.getKeyFrame(showTime), 0, 0);  
    }
}