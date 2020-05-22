public JButton createButton(String name, Color color) {
    JButton button = new JButton(name);
    button.setForeground(color);
    button.addActionListener(listener);
    return button;
}