for(int i=0;i<enemies.size();i++){
    bullet = new Rectangle(bulletX,bulletY,6,15);
    ship = new Rectangle(playerX,playerY,100,100);
    if(bullet.intersects(enemies.get(i).getEnRect())){
        enemies.remove(enemies.get(i));
        score++;
        shoot=false;
        bullet= new Rectangle(0,0,0,0);
    }
    if(ship.intersects(enemies.get(i).getEnRect())){
        gameover=true;
        play=false;
    }
}