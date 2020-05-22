btnNewButton_1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        for (JTextField field : fields) {
            field.setText("0.00");
        }
    }
});