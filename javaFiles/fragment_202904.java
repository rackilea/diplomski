// Add this method in class cAccount:
public void setToAmount(double amount) {
    balance = amount;
}

// Add a text field named "setAmountField" to enter the amount, and a button (choose a name) to apply it, and add this listener to the button:
class SetAmountListener implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent event)
    {     
        double setToAmount = Double.parseDouble(setAmountField.getText());

        account.setToAmount(setToAmount);

        result = account.getBalance();
        resultLabel.setText("New Balance: " + result);
        setAmountField.setText("0.00");
     }           
}