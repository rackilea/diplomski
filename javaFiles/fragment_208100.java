public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                //left
                System.out.println("leftPressed");
                keyLeftPressed = true;
                break;
            }
            case KeyEvent.VK_RIGHT: {
                //right
                System.out.println("rightPressed");
                keyRightPressed = true;
                break;
            }
        }
    }