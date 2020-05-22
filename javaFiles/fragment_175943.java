if (z + initVelZ < 100){ //Collision detection for ceiling of 100 units
    initVelZ *= -1;
}
if (x + initVelX < 50){ //Collision detection for if ball moves 50 units away from origin in x
    initVelX *= -1;
}