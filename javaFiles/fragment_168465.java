//snap the camera to the sprite's center.
if(wasd_isDown){
    float centerX = sprite.getX()+sprite.getWidth()/2;
    float centerY = sprite.getY()+sprite.getHeight()/2;
    camera.position.set(x,y, 0);
}