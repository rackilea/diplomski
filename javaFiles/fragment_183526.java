public void update(float delta){
    distance += speed * delta;  //  distance = speed * time
    speed += 0.15f;

    if (speed > MAX_SPEED) speed = MAX_SPEED;
}