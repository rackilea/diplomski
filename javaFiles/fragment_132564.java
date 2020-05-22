//do on w key press
this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W,0, false), "player1MoveUp");
//do on w key release
this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_W,0, true), "stop");

Action player1MoveUp = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        move(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                movePlayer(player1, MovementDirection.UP);
            }
        });
    }
};

//note that you can't use the same timer for both
//players if you don't want a button release stop both
private void move(Action play) {
    if((timer !=null) && timer.isRunning()) { //timer is a field 
        return;
    }
    timer = new Timer(100, play);
    timer.setInitialDelay(0);
    timer.start();
}

Action stop = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        timer.stop();
    }
};