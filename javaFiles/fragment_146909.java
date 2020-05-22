public void withdraw(double amount) {
    if(balance - amount < 0) {
        JOptionPane.showMessageDialog(null, "Can't withdraw that amount, account balance is too low.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        balance = balance - amount;
    }
}