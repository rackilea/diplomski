public void keyPressed(KeyEvent e) {
    System.out.println("The following key was pressed: "+e.getKeyChar());
    System.out.println("With the following key code: "+e.getKeyCode());
    System.out.println("Is that the expected output?");
    keys[e.getKeyCode()] = true;
}