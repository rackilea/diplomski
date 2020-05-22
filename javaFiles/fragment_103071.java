private void myTextArea_KeyTyped(java.awt.event.KeyEvent evt) {                                    

    String key = String.valueOf(evt.getKeyChar());
    String validChars = "[a-zA-Z0-9]";

    if(!key.matches(validChars))
        evt.consume();
 }