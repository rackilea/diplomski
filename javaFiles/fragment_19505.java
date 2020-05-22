private static void main(String args[]){
    ArrayList<Account> accounts = new ArrayList<>();

    Account account1 = new Account(params1); // Constructor
    accounts.add(account1);

    Account account2 = new Account(param2); // Constructor
    accounts.add(account2);

    Account account3 = new Account(params3); // Constructor
    accounts.add(account3);

    Account account4 = new Account(params4); // Constructor
    accounts.add(account4);

}

public static Account getAccountByNumber(int accountNumber) {
    for (Account acc : accounst) {
        if (acc.getAccountNumber().equals(String.valueOf(accountNumber)))
            return account;
    }
}