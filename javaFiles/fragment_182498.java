JPanel panel = new JPanel();
final JTextField textField = new JTextField(20);
final JTextArea textArea = new JTextArea(2,20);
panel.add(textField);
panel.add(textArea);
frame.getContentPane().add(panel);
textField.addActionListener(new ActionListener() {
    @Override public void actionPerformed(ActionEvent e) {
        String text = textField.getText();
        if (text.equals("hi")) {
            textArea.setText("Hey!");
        }
    }
});