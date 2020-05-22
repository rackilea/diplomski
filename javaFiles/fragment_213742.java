PropertyChangeListener pl = new PropertyChangeListener() {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (!(evt.getNewValue() instanceof JTextField)) return;
        JTextField field = (JTextField) evt.getNewValue();
        // crude check to not overdo it
        int dot = field.getCaretPosition();
        if (dot == 0) {
            field.selectAll();
        }
    }
};
KeyboardFocusManager.getCurrentKeyboardFocusManager()
    .addPropertyChangeListener("permanentFocusOwner", pl);