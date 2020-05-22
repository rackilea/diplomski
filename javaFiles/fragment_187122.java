public void keyReleased(KeyEvent e) {
    if (10 == e.getKeyCode()) {
        Rechner rechner = new Rechner(input.getText());
        input.setText(rechner.rechnen().toPlainString());
    }
    if (27 == e.getKeyCode()) {
        input.setText("");
    }
}