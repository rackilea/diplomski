// Define keys: up, right, down, left
// 0 - not pressed, 1 - pressed
private int[] keys = {0, 0, 0, 0};

// player control
public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    // we set the corresponding 'key indicator' to 1 when it is pressed
    switch(key){
        case(KeyEvent.VK_LEFT): dx = -speed; keys[3] = 1; break; 
        case(KeyEvent.VK_RIGHT): dx = speed; keys[1] = 1; break;
        case(KeyEvent.VK_UP): dy = -speed; keys[0] = 1; break;
        case(KeyEvent.VK_DOWN): dy = speed; keys[2] = 1; break;
        case(KeyEvent.VK_SPACE): fireOn = true; break;
    }
}

public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();
    // now before resetting the speed we check if the opposite key
    // is still pressed
    switch(key){
        case(KeyEvent.VK_LEFT): if(keys[1]==0){dx = 0;} keys[3] = 0; break;
        case(KeyEvent.VK_RIGHT): if(keys[3]==0){dx = 0;} keys[1] = 0; break;
        case(KeyEvent.VK_UP): if(keys[2]==0){dy = 0;} keys[0] = 0; break;
        case(KeyEvent.VK_DOWN): if(keys[0]==0){dy = 0;} keys[2] = 0; break;
        case(KeyEvent.VK_SPACE): fireOn = false; break;
    }
}