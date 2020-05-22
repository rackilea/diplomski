for(Iterator<Enemy> iterator = enemies.iterator(); iterator.hasNext();){
    Enemy e = iterator.next();
    bullet = new Rectangle(bulletX,bulletY,6,15);
    ship = new Rectangle(playerX,playerY,100,100);
    if(bullet.intersects(e.getEnRect())){
        iterator.remove();
        score++;
        shoot=false;
        bullet= new Rectangle(0,0,0,0);
    }
    if(ship.intersects(e.getEnRect())){
        gameover=true;
        play=false;
    }
}