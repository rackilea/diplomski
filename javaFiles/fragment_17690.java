public void floorBeginContact(Contact contact){
state = State.LANDED;
 canApplyForce = true;
}

public void floorEndContact(Contact contact){
state = State.FLYING;
}

boolean canApplyForce = true;

private void jump(){
if(state == State.LANDED){
    if(canApplyForce)
    body.applyForceToCenter(0f, 30f);
   canApplyForce = false;
    System.out.println(i++ + " - Jump!");
}
}

public void act(float delta){
...

if(Gdx.input.isKeyPressed(Keys.SPACE)){
    jump();
 }
   }