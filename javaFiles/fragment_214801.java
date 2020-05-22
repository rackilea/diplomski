public class TransactionProcess {

    //Always Provide another class for process.
    //Pass the bankAccount of the user
    public void deposit(BankAccount bankAccount, double depositAmount) {
        //Get the CurrentBalance
        double currentBalance = bankAccount.getCurrentBalance();

        //First Argument : set the Id of transaction
        //Second Argument : set the Type of Transaction
        //Third Argument : set the TransactionAmount 
        //Fourth Argument : set the Balance Before the transaction (for record purposes)
        Transaction transaction = new Transaction(bankAccount.getTransactions().size(),"Deposit",depositAmount,currentBalance);

        if (depositAmount <= 0) {
            System.out.println("Amount to be deposited should be positive");
        } else {
            //Set the updated or transacted balance of bankAccount.
            bankAccount.setCurrentBalance(currentBalance + depositAmount);
            //then set the MoneyAfterTransaction
            transaction.setMoneyAfterTransaction(bankAccount.getCurrentBalance());
            //after the transaction add it to the list of Transaction of bankAccount
            bankAccount.getTransactions().add(transaction);
        }

    }

    // Explanation same as above
    public void withdraw(BankAccount bankAccount,double withdrawAmount) {
        double currentBalance = bankAccount.getCurrentBalance();
        Transaction transaction = new Transaction(bankAccount.getTransactions().size(),"Withdraw",withdrawAmount,currentBalance);

        if (withdrawAmount <= 0) {
            System.out.println("Amount to be withdrawn should be positive");
        } else {
            if (currentBalance < withdrawAmount) {
                System.out.println("Insufficient balance");
            } else {
                bankAccount.setCurrentBalance(currentBalance - withdrawAmount);
                transaction.setMoneyAfterTransaction(bankAccount.getCurrentBalance());
                bankAccount.getTransactions().add(transaction);
            }
        }

    }

}