public void keyPressed(KeyEvent e) {
    System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
    if (e.getKeyCode() == 37)
        dx -= 5; // 37 is left
    if (e.getKeyCode() == 39)
        dx += 5; // 39 is right
    // if (e.getKeyCode() == 40) dy -= 5; //40 is down
    if (e.getKeyCode() == 38 && jumping == false){
        // if on the ground,
        // i.e. only jump if on the ground
        // 38 is up
        dy -= 20; // <- jump size 20
        jumping = true;
    }
}