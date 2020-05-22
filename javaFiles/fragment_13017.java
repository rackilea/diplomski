button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if(b.getText().equals("")){
            //Logic to determine what it should be set to...
            b.setText("0"); // or "*"
        }
    }
});