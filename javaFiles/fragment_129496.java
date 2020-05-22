public void setComponents() { // method to set the components
    setSize(400, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setTitle("My Swing Demo");
    setLayout(new FlowLayout());

    lblName.setText("Name");
    lblPassword.setText("Password");

    txtfName.setText("Name");// try

    pwdfPassword.setText("Password");

    btnSubmit.setText("Submit");
    btnCancel.setText("Cancel");
    btnReset.setText("Reset");
    setVisible(true);
}