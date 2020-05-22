private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {                                     
    char c=evt.getKeyChar(); //get input from text field character by character
    if (!((c >= '0') && (c <= '1') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) 
    {
        getToolkit().beep();
        evt.consume();
    }
}