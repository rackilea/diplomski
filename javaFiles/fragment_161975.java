FocusAdapter fa = new FocusAdapter() {
    @Override
    public void focusGained(FocusEvent e) {
        TextField.setBackground(new Color(220, 220, 255));
        Slider.setBackground(new Color(220, 220, 255));
        JPriorityEditor.this.selectedRow = rowName;
    }

    @Override
    public void focusLost(FocusEvent e) {
        TextField.setBackground(Color.WHITE);
        Slider.setBackground(Color.WHITE);
    }
});
Slider.addFocusListener(fa);
TextField.addFocusListener(fa);