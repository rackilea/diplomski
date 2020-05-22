private boolean down, up, left, right;
//...

public void keyPressed(KeyEvent ke) {
    switch (ke.getKeyCode()) {
        case KeyEvent.VK_RIGHT:
            right = true;
            break;
        case KeyEvent.VK_LEFT:
            left = true;
            break;
        case KeyEvent.VK_DOWN:
            down = true;
            break;
        case KeyEvent.VK_UP:
            up = true;
            break;
    }
    updateState();
}

public void keyReleased(KeyEvent ke) {
    switch (ke.getKeyCode()) {
        case KeyEvent.VK_RIGHT:
            right = false;
            break;
        case KeyEvent.VK_LEFT:
            left = false;
            break;
        case KeyEvent.VK_DOWN:
            down = false;
            break;
        case KeyEvent.VK_UP:
            up = false;
            break;
    }
    updateState();
}

protected void updateState() {
    if (right) {
        cordX += 5;
    } else if (left) {
        cordX -= 5;
    }
    if (down) {
        cordY += 5;
    } else if (up) {
        cordY -= 3;
    }
    repaint();
}