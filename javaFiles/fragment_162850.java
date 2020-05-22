JLabel label = new JLabel("Password") {
    @Override public Dimension getMaximumSize() {
        return super.getPreferredSize();
    }
};
JPasswordField field = new JPasswordField() {
    @Override public Dimension getMaximumSize() {
        return super.getPreferredSize();
    }
};