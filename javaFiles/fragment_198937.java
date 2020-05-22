public int fundTransfer(int accountNumber, int accountNumber1, int amount) throws InvalidAccountNumberException, InsufficientBalanceException{

    Account account=searchaccount(accountNumber);
    Account account1= searchaccount(accountNumber1);

    if(amount>0){
        account.setAmount(account.getAmount()-amount);
        account1.setAmount(account1.getAmount()+amount);
    }else{
        throw new InsufficientBalanceException();
    }
}