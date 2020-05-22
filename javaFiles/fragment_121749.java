public void keyPressed(KeyEvent pressedKey) {
    int keyCode = pressedKey.getKeyCode();

    if(keyCode == KeyEvent.VK_RIGHT){
        this.player.setIsPlayerMovingRight(true);
    }
    if(keyCode == KeyEvent.VK_LEFT){
        this.player.setIsPlayerMovingLeft(true);
    }
    if(keyCode == KeyEvent.VK_SPACE){
        if(this.player.getIsPlayerMovingLeft() == false && this.player.getIsPlayerMovingRight() == false){
            this.player.shoot();
        }
    }
}