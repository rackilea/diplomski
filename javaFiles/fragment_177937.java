public class CheckingAccount {
    final JButton depositAmount = new JButton("Deposit");  
    final JTextField tAmount = new JTextField();

    //Provide the JTable to the CheckingAccount when you construct it!
    public CheckingAccount(final JTable table) {
        depositAmountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() > -1) {
                    // assuming from your code that you want to set the
                    // textfield's value at the table's selected row
                    try {
                        Integer amount = Integer.parseInt(textField.getText());
                        table.getModel().setValueAt(amount, table.getSelectedRow(), 4);
                    } catch (NumberFormatException nfe) {
                        // User did not provide a number.
                        // do nothing? show dialog? you name it!
                    }
                }
            }
        });
    }
}