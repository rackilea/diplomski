public void keyPressed(KeyEvent e) {
     heldKeys++;
     ... other code ...
}

public void keyReleased(KeyEvent e) {
     heldKeys--;
     ... other code ...
     if(heldKeys == 0) {
          velocity = 0;
     }
}