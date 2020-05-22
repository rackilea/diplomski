JButton btnNewButton = new JButton("Pepsi");
btnNewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        changeD();
    }
});
btnNewButton.setBounds(23, 11, 80, 29);
contentPane.add(btnNewButton);
JButton btnNewButton_1 = new JButton("Sprite");

//Wrong button here !!!!!!!!!!!!!!!!!!! Should be btnNewButton_1 
btnNewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        changeD();
    }
});
btnNewButton_1.setBounds(113, 11, 80, 29);
contentPane.add(btnNewButton_1);
JButton btnFanta = new JButton("Fanta");
btnNewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        changeD();
    }

});