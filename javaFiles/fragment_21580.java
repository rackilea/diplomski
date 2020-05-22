float acceleration = 15;
private void accelerateX(float speed) {
    moveSpeed += (float) (speed * 0.0096);
    if (moveSpeed >= MAX_MOVE_SPEED) {
        moveSpeed = MAX_MOVE_SPEED;
    }else if(moveSpeed<=-MAX_MOVE_SPEED){ moveSpeed= - MAX_MOVE_SPEED;}
}
public void moveRight() {
    printPos("Moving Right!");
    accelerateX(acceleration);
}

public void moveLeft() {
    printPos("Moving Left!");
    accelerateX(-acceleration);
}
//call this every update.
public void update(){
    float minMoveSpeed = 1;
    //snap to zero movement if movespeed is too slow.
    //this is so the player actually stops moving eventually. otherwise
    //the dampening affect would constantly shift the player to and fro.
    if(this.moveSpeed<minMoveSpeed && this.moveSpeed>-minMoveSpeed){
        this.moveSpeed = 0;
    }
    else{
        float dampening = 1f;
        //Counter velocity. this will bring mario to a halt over a number of updates
        //play with the value of dampening to get right effect.
        double sign = -(int)Math.signum(moveSpeed);
        float dampeningValue = dampening*sign;
        this.moveSpeed += dampeningValue;
    }
    xPos+= this.moveSpeed;
}