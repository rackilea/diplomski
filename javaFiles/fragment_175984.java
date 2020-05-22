frame.addKeyListener(new KeyListener() {
    @Override
    public void keyReleased(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_UP:
                game.upPressed=false;
                break;
            case KeyEvent.VK_DOWN:
                game.downPressed=false;
                break;
            case KeyEvent.VK_LEFT:
                game.leftPressed=false;
                break;
            case KeyEvent.VK_RIGHT:
                game.rightPressed=false;
                break;

        }
    }

    @Override
    public void keyTyped(KeyEvent event) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_UP:
                game.upPressed=true;
                break;
            case KeyEvent.VK_DOWN:
                game.downPressed=true;
                break;
            case KeyEvent.VK_LEFT:
                game.leftPressed=true;
                break;
            case KeyEvent.VK_RIGHT:
                game.rightPressed=true;
                break;

        }
    }
});