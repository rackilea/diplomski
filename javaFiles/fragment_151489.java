public void update(){
    x += xSpeed;
    y += ySpeed;

    if (x < size || x > Gdx.graphics.getWidth() - size) 
        xSpeed = -xSpeed;


    if (y < size || y > Gdx.graphics.getHeight() - size) 
        ySpeed = -ySpeed; 

    cic.x = x;
    cic.y = y;
    cic.radius = size;

}