public class Animation {

  public static final int ANIMATION_LOOPING = 0;
    public static final int ANIMATION_NONLOOPING = 1;

private Image [] sprites;
private float frameDuration ; 

public Animation (Image ... sprites, float frameDuration){

this.sprites =sprites;
this.frameDuration = frameDuration;
}  

//this function takes a the walking time of the soldier 
public Image getKeyFrame(float stateTime , int mode){


int frameNumber = (int) stateTime/ frameDuration;

if(mode == ANIMATION_NONLOOPING){
frameNumber = Math.min( sprites.length , frameNumber);
}
else{
frameNumber = frameNumber % sprites.length;
}

return sprites[frameNumber];
}

}