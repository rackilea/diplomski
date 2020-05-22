public Display() {
    this.setLayout(new BoxLayout(display, BoxLayout.Y_AXIS));
    this.add(result);
    this.setSize(400, 100);
    result.setHorizontalAlignment(JTextField.RIGHT);
    result.setEditable(false);
    this.setVisible(true);
}