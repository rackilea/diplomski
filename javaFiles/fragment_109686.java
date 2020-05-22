public void withdraw(double amount) {
// place logic to prevent the account from being overdrawn
// that is do not allow a negative balance

     if(balance < amount)
     {
        // print error message or do something
     }
     else
     {
        // withdraw the money
        balance -= amount;
        // print message or do something
     }
}