protected boolean keyChar(char c, int status, int time) {       
    if(c == Keypad.KEY_SPACE) {
           listContainer.setVerticalScroll();
    }
    return super.keyChar(c, status, time);
}