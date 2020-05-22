@Override
protected boolean processKeyBinding(KeyStroke ks,
        KeyEvent e, int condition, boolean pressed) {
    boolean result = super.processKeyBinding(ks, e, condition, pressed);
    if (isEditing() && pressed) return true;
    return result;
}