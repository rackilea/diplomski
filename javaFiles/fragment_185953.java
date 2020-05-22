public void update(float delta){
    time += delta;
    if(time >= 3.0f)
        gameOver = true;
    sprite.setPosition(x, y);
}