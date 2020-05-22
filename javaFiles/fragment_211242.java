public boolean checkAccountNumber(int a) {

    for (Account account of Bank.accounts){
        if (account.accNumber.equals(a)) {
            return true;
        }
    }
    return false;
}