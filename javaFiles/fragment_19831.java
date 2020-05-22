if (e.getSource() == deposit) {
    accountType.deposit(money);
} else if (e.getSource() == withdraw) {
    if (money % 20 == 0) {
        try {
            accountType.withdraw(money);
        }
        catch (InsufficientFunds ife) {
            System.out.println("No funds to withdraw.");
        }
        catch (Exception e) {
            System.out.println("Some other error occurred.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Entry must be in $20 increments.");
    }
}