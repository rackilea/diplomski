public void banking() {

    // remove the below line
    // Account account = new Account();

    account.deposit();
    account.withdraw();

    int Newbalance = (int) (Math.round(account.balance));

    switch (Newbalance) {
        case 1:
            account.deposit();
            break;
        case 2:
            account.withdraw();
            break;
        case 0:
            System.exit(0);
        default:
            break;
    }
}