private BankAccount getTypeAccount(String accountType)
{
     for(BankAccount account : bankAccounts)
     {
           if(account.getCode().equals(accountType))
           {
                return account;
           }
     }
     return null;
}