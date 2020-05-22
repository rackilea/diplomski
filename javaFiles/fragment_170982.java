public BankAccount(int initialBalance)
{
    if (initialBalance < 0){
        throw new IllegalArgumentException("The initial balance may not be negative.");
    }
    balance = initialBalance; 
}