private class CalcButtonListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        double subtotal, total, tax;
        double input1, input2, input3;

        /* assign the text field inputs to the variables */
        input1 = Double.parseDouble(txtItem1.getText());                
        input2 = Double.parseDouble(txtItem2.getText());
        input3 = Double.parseDouble(txtItem3.getText());

        subtotal = input1 + input2 + input3;                                // this is what you need don't you?

        tax = subtotal * TAX_RATE;

        total = subtotal + tax;

        output.setText("Your total is:  " + total);
    }
}