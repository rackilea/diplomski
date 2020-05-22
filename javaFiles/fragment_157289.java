yourTextField.addFocusListener(new FocusListener() {
    @Override
    public void focusGained(FocusEvent e) {
       ((JTextField)e.getSource()).selectAll();
    }

    @Override
       public void focusLost(FocusEvent e) {}
});