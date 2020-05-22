pause_btnDialog.addListener(new ChangeListener() {
        public void changed (ChangeEvent event, Actor actor) { 
            pause();
        }
});


@Override
public void render(float delta) {
    // clear previous frame
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen

    camera.update();
    spriteBatch.begin();
    spriteBatch.setProjectionMatrix(camera.combined);
    if(this.state==State.RESUME)
    stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
    TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);

    spriteBatch.draw(Background,0,0);
    spriteBatch.draw(currentFrame,catX,catY); // Draw current frame at (50, 50)

    spriteBatch.draw(meter,190,990);
    spriteBatch.draw(progressbar_background,20,1170);
    spriteBatch.draw(progressbar_knob,18,1170);
     if(this.state==State.RESUME){
    //Moving player on desktop
    if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        catX -= Gdx.graphics.getDeltaTime() * catSpeed;
    if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        catX += Gdx.graphics.getDeltaTime() * catSpeed;

    if(Gdx.input.isKeyPressed(Input.Keys.UP))
        catY += Gdx.graphics.getDeltaTime() * catSpeed;
    if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
        catY -= Gdx.graphics.getDeltaTime() * catSpeed;

    //Mobile acceleration
    if (Gdx.input.isPeripheralAvailable(Input.Peripheral.Accelerometer))
    {
        catX -= Gdx.input.getAccelerometerX();
        catY += Gdx.input.getAccelerometerY();
    }
    if(catY<0) {
        catY =0;
    }
    if(catY>  Gdx.graphics.getWidth()-100) {
        catY =Gdx.graphics.getWidth()-100;
    }
    if(catX<0){
        catX =0;
    }
    if(catX> Gdx.graphics.getHeight()-250) {
        catX =Gdx.graphics.getHeight()-250;
    }
    }
    switch (state)
    {
        case RUN:
            //do suff here
            break;
        case PAUSE:
            break;
        case RESUME:
            break;

        default:
            break;
    }

    spriteBatch.end();
    stage.act(); //acting a stage to calculate positions of actors etc
    stage.draw(); //drawing it to render all
}

public void pause(){

   this.state = State.PAUSE;
   pauseGroup = new Group;
   Image semiTransparentBG= ......
   // setSize(Size of screen) and make it semi transparent.
   pauseGroup.addActor(semiTransparentBG);

  //crate all other pause UI buttons with listener and add to pauseGroup

  stage.addActor(pauseGroup);

 }

 public void resume() {

   if(this.state = State.PAUSE){
      this.state = State.RESUME;
      pauseGroup.remove();
   }  
 }