class WithdrawListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent event)
    {    
        double withdrawl = Double.parseDouble(withdrawField.getText());

        account.withdraw(withdrawl);

        result = account.getBalance();
        resultLabel.setText("New Balance: " + result);
        withdrawField.setText("0.00");
     }           
 }