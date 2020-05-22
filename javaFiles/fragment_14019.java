public void actionPerformed(ActionEvent ae) {
    if (!text.getText().equals(defaultMessage)) {
        if (!text.getText().isEmpty()) {
            label = new JLabel(text.getText());
            label.setBounds(10, y, 380, 20);
            y = y - 20;
            frame.add(label);
            frame.revalidate();
            frame.repaint();
        }
    }
}