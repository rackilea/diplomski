class MyListener implements KeyListener {

    private ArrayList< Integer > keysPressed = new ArrayList< Integer >();

    public MyListener() {

    }

    @Override
    public void keyPressed( KeyEvent e ) {
        if ( !keysPressed.contains( e.getKeyCode() ) ) {
            keysPressed.add( e.getKeyCode() );
        }

        movePlayer();
    }

    @Override
    public void keyReleased( KeyEvent e ) {
        keysPressed.remove( e.getKeyCode() );
    }

    public void movePlayer() {
        //move player based on what keys are pressed.
    }
}