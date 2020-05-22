public void run() {
    while(true) {
        //change the game state
        move();

        //draw the changes to the state that I just made
        repaint();

        //wait before moving to the next "frame"
        try {
           Thread.sleep(50);
        } catch ( InterruptedException ie ) {
        }
    }
}

private void move() {
    myBall.move();
}