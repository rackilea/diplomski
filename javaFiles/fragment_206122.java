KeyHandler keyHandler = new KeyHandler();
functionPanel.addKeyListener(keyHandler);

private class KeyHandler implements KeyListener {
    @Override
    public void keyPressed(KeyEvent ev) {
        if (ev.getKeyCode() == KeyEvent.VK_C) /* C for clear */ {
            op1HasValue = op2HasValue = operationHasValue = false;
            op1Str = "";
            op2Str = "";
            operation = "";
            answer = "";
            answerField.setText("");
        }
    }

    @Override
    public void keyReleased(KeyEvent ev) {}

    @Override
    public void keyTyped(KeyEvent ev) {}
}