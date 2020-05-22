ActionListener commonListener = new ActionListener() {

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o instanceof JTextField) {
            JTextField textField = (JTextField)o;
            input[5] = textField.getText();
            textField.setVisible(true);
        }
    }
};