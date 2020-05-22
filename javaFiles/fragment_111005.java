public void keyTyped(KeyEvent e) {
    displayInfo(e, "KEY TYPED: ");
}

/** Handle the key-pressed event from the text field. */
public void keyPressed(KeyEvent e) {
    displayInfo(e, "KEY PRESSED: ");
}

/** Handle the key-released event from the text field. */
public void keyReleased(KeyEvent e) {
    displayInfo(e, "KEY RELEASED: ");
}