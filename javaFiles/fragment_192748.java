public void update(){
     player.playerMove();

     player.cam.update();
     player.cam.position.set(player.x,player.y,0);


}