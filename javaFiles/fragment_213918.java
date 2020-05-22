private void jCashReceivedKeyTyped(java.awt.event.KeyEvent evt) {
    char c = evt.getKeyChar(); //Allows input of only Numbers and periods in the textfield
    if ((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_PERIOD)) {
        String s = getTextFieldCash();
        int dot = s.indexOf(".");
        if(dot != -1 && c == KeyEvent.VK_PERIOD) {
            evt.consume();
        } else if(dot != -1 && c != KeyEvent.VK_BACK_SPACE){
            String afterDecimal = s.substring(dot + 1);
            if (afterDecimal.length() > 2) {
                evt.consume();
            }
        }
    }
}