private boolean movingLeft, movingRight, movingUp, movingDown;

@Override
public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        movingLeft = true;
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        movingRight = true;
    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
        movingUp = true;
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        movingDown = true;
    }
}

@Override
public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        movingLeft = false;
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        movingRight = false;
    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
        movingUp = false;
    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        movingDown = false;
    }
}

@Override
public void actionPerformed(ActionEvent e) {
    if (movingLeft) x -= 1;
    if (movingRight) x += 1;
    if (movingUp) y -= 1;
    if (movingDown) y += 1;
    repaint();
}

/* ... rest of the code the same ... */