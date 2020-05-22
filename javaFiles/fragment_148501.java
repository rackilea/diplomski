isCheatCode(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_W) {
        int mods = e.getModifiers();
        return (mods & InputEvent.ALT_MASK != 0)
        && mods & InputEvent.CTRL_MASK != 0;
    }
    return false;
}