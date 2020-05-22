class DepositListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent event)
    {     
        double depositAmount = Double.parseDouble(depositField.getText());

        account.deposit(depositAmount);
        result = account.getBalance();
        resultLabel.setText("New Balance: " + result);
        depositField.setText("0.00");
     }           
 }