public double getTotalBalance(ArrayList<BankAccount> accounts)
{
    double sum = 0;
    while (accounts.size() > 0)
    {
         BankAccount account = accounts.remove(0); // Not recommended
         sum = sum + account.getBalance();
    }
    return sum;
}