TextureRegion[] character;
boolean isRight;    

public Student(float speed, int x, int y){
    player = new Texture("student.png");
    TextureRegion[][] tmp= TextureRegion.split(player,450/3,450/3);
    character = new TextureRegion[9];
    int index = 0;
    for(int i=0; i <3; i++){
        for(int j=0; j < 3; j++){
            character[index++] = tmp[i][j];}
    }

    TextureRegion runningFrames[]=new TextureRegion[3];

    for (int i=0;i<runningFrames.length;i++)
        runningFrames[i]= character[i];

    playerAnimation = new Animation<TextureRegion>(speed, runningFrames);
    playerAnimation.setPlayMode(Animation.PlayMode.LOOP);
    pX=x;
    pY=y;

}

public void goLeft(){
    pX-=5;
    if(pX < -10){
        pX = -10;
    }
    if(isRight){
       isRight=false;
       for (TextureRegion textureRegion:playerAnimation.getKeyFrames())
           if(textureRegion.isFlipX()) textureRegion.flip(true,false);
    } 
}

public void goRight(){
    pX+=5;
    if(!isRight){
       isRight=true;
       for (TextureRegion textureRegion: playerAnimation.getKeyFrames())
           if(!textureRegion.isFlipX()) textureRegion.flip(true,false);
    }
}