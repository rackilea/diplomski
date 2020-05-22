enum eSingleton implements KeyListener {
    INSTANCE;

    private boolean[] keyUp = new boolean[256];
    private boolean[] keyDown = new boolean[256];
    private boolean listen;

    public void update(){
        keyUp = new boolean[256];
    }

    public void listen(final boolean startStop){
        listen = startStop;
    }

    public boolean isKeyUp(int key){
        return keyUp[key];
    }

    public boolean isKeyDown(int key){
        return keyDown[key];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyUp[e.getKeyCode()] = false;
        keyDown[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyUp[e.getKeyCode()] = true;
        keyDown[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}