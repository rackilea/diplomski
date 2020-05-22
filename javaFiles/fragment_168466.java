if(!wasd_isDown){
    float deltaX = 0;
    float deltaY = 0;
    float MOVE_DIST = 10;//or whatever you need.

    if(leftPressed) deltaX = -MOVE_DIST;
    else if(rightPressed) deltaX = MOVE_DIST;

    if(upPressed)deltaY = MOVE_DIST;
    else if(downPressed)deltaY = -MOVE_DIST;

    camera.position.add(deltaX, deltaY, 0);
}