private void initTimer() {
    timer = new Timer(500, this);
    timer.start();
}

@Override
public void actionPerformed(ActionEvent e) {
    //move player 1
    randomMovePlayer(player1);
    repaint();
}

//randomly move player
private void randomMovePlayer(Player player) {

    Random rand = new Random(); //refactor it to a field
    float direction = rand.nextFloat();
    if(direction < .25) {
        playerMoveLeft(player);
    }else if(direction < .5) {
        playerMoveUp(player);
    }else if(direction < .75) {
        playerMoveDown(player);
    }else  {
        playerMoveRigth(player1);
    }
    //todo improve logic to get the right movement within bounds
}