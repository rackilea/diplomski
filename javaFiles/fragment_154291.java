public void doPayment(Acccount account) throws MyException {
    synchronized(account){
    if (isMoneyAvailable(account)) {
        confirmPayment(account);
    }else{
        throw new MyException(myErrorCode);
    }
}
}