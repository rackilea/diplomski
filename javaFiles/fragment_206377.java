private void update(){
    tempx = player.getX(); // tempx now is the same as the players x location
    tempy = player.getY();
    collided = checkCollision();
    if(collided == false){
        player.update();
    }
    else if(collided){
        player.setX((int)tempx);  // you set players location equal to temp, which is 
        player.setY((int)tempy);  // already the players location
        System.out.println("COLLIDED");
    }
}