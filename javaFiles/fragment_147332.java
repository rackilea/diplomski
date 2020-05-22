public Double getAccountSaldo(String customerNbr, String accountNbr) {
    double balance = 0;
    Customer custNbr = find(customerNbr);
    // Shouldn't it be "Account acctNbr = find(accountNbr);" here? 
    // Problem is I can't access that method in this class...

    if(custNbr != null){
    for (Account x : printAccounts(customerNbr)) {
        if (accountNbr.equals(x.getNbr())) {
            balance += x.getSaldo();

        }        
    }
    }
    return balance;
}