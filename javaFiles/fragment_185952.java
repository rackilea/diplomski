public void reset(){
    x = minX + (int)(Math.random() * (maxX - minX + 1));
    y = minY + (int)(Math.random() * (maxY - minY + 1));
    time = 0.0f;
    gameOver = false;
    sprite.setPosition(x, y);
}