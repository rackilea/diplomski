int speedUp(int increaseBy) {
    currentSpeed = Math.min(currentSpeed + increaseBy,MAXIMUM_SPEED);
    return currentSpeed;
}

int slowDown(int decreaseBy) {
    currentSpeed = Math.max(currentSpeed - decreaseBy,0);
    return currentSpeed;
}