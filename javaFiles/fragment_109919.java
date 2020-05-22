KeboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {       
    @Override
    public boolean dispatchKeyEvent(KeyEvent ke) {
        if (yourComponent.hasFocus && ke.getID == KeyEvent.KEY_TYPED) {
            // Your code here
            // Use ke.getKeyChar() to detect which key was pressed.
        }
    }
}