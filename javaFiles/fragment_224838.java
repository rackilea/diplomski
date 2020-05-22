btnNewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        String n1 = textField.getText();
        String pass = passwordField.getText();

        if(n1.equals("admin") &&  pass.equals("sales")){

        SALES j=new SALES();

        j.setVisible(true);
        dispose();

        }
        else {

        JOptionPane.showMessageDialog(null,"Wrong Password / Username");
        textField.setText("");
        passwordField.setText("");
        textField.requestFocus();
        }

    }
});