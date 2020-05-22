public DrawingCanvas() {
        super();
        this.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_KP_DOWN:
            case KeyEvent.VK_UP:
            case KeyEvent.VK_KP_UP:
                xFlag = false;
                yFlag = true;
                reverseY();
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_KP_LEFT:
            case KeyEvent.VK_KP_RIGHT:
                xFlag = true;
                yFlag = false;
                reverseX();
                break;
            default:
                System.out.println(" * NOT an action key " + e.getKeyChar());
                break;
        }
    }