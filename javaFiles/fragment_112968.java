private void keyType(char key) {

    int keyCode = (int) key;

    Robot r = new Robot();
    r.keyPress(KeyEvent.VK_A);
    r.keyRelease(KeyEvent.VK_A);
}