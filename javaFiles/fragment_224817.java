public final void withdraw(double amount, String pass) {
 if (checkPassword(pass) && checkFundsAvailable(amount)) {
    setBalance(getBalance() - amount);
 } else {
    System.out.println("Rejected.");
 }
}

protected boolean checkFundsAvailable(double amount) {
  return amount <= getBalance();
}