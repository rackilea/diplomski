if(key == KeyEvent.VK_SPACE && !tempObject.isFiring()){
    int velocity = tempObject.getLookingLR() * 5;
    float posX = tempObject.getX() + velocity;
    float posY =tempObject.getY()+32;
    handler.addObject(new Bullet(posX,posY, ObjectId.Bullet, velocity,handler));
    tempObject.setFiring(true);
}