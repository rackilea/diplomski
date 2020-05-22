public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == 37)
        dx -= 5; // 37 is left
    if (e.getKeyCode() == 39)
        dx += 5; // 39 is right
    if (e.getKeyCode() == 38 && jumping == false){
        dy -= 9; // <- jump size set to 9 (half is 10)
        jumping = true;
    }
}