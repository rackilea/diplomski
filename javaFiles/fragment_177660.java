Fixture fixA = contact.getFixtureA();
Fixture fixB = contact.getFixtureB();

Checkpoint collidedCheckpoint = null;
if(fixA.getUserData == Type.CHECKPOINT){ //Check if fixA is a Checkpoint
    collidedCheckpoint = ((Checkpoint)fixA.getBody().getUserData());
} else if(fixB.getUserData == Type.CHECKPOINT){ //Check if fixB is a Checkpoint
    collidedCheckpoint = ((Checkpoint)fixB.getBody().getUserData());
}
if(collidedCheckpoint != null){
    //Get the color of the Checkpoint by saving a int in the enum or something else
    int color = collidedCheckpoint.color; // 1
} else {
    //Not with a Checkpoint collided
}