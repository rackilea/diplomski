public JLabel() {
    this("", null, LEADING);
}

public JLabel(String text, Icon icon, int horizontalAlignment) {
    setText(text);
    setIcon(icon);
    setHorizontalAlignment(horizontalAlignment);
    updateUI();
    setAlignmentX(LEFT_ALIGNMENT);
}