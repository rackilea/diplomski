JComponent comp = new JPanel();
for (int i = 0; i < 10; i++) {
    comp.add(new JTextField(5));
}
PropertyChangeListener l = new PropertyChangeListener() {
    Component owner;
    Color background;
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (owner != null && evt.getOldValue() == owner) {
            owner.setBackground(background);
            owner = null;
        } 
        if (evt.getNewValue() != null) {
            owner = (Component) evt.getNewValue();
            background = owner.getBackground();
            owner.setBackground(Color.YELLOW);
        }
    }
};
KeyboardFocusManager.getCurrentKeyboardFocusManager().addPropertyChangeListener("permanentFocusOwner", l);