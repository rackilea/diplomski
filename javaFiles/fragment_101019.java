for(Transaction transaction : transactionList) 
{
    //get the type of account chk001, sav001, loc001 ..
    String accountType = transaction.getBankAccountType();
    BankAccount account = getTypeAccount(accountType)

    if(account != null)
    {
        transaction.applyTransaction(account);  
    } 

}