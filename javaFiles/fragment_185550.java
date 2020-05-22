for(GameObj brick: bricks){
    if (ball.hitBy(brick)){
        if(brick.brickColour == Color.YELLOWGREEN) {
             // yellow logic
        } else {
             // blue logic
        }
    }
}