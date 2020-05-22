public static void main(String[] args) throws InsufficientFunds {
    if (e.getSource() == deposit) {
        accountType.deposit(money);
    } else if (e.getSource() == withdraw) {
        if (money % 20 == 0) {
            accountType.withdraw(money);
        } else {
            JOptionPane.showMessageDialog(null, "Entry must be in $20 increments.");
        }
    }
}