public void update(){
    player.playerMove();

    player.cam.position.set(player.x,player.y,0);
    player.cam.update();
    batch.setProjectionMatrix(player.cam.combined);

}