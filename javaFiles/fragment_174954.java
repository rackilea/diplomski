ArrayList<Account> accounts = new ArrayList<>();

    Account exampleAccount = new Account();
    exampleAccount.setFirstName("John");
    exampleAccount.setLastName("Doe");
    exampleAccount.setBalance(101.13d);

    accounts.add(exampleAccount);

    for(Account account : accounts) {
        System.out.println("Name: " + account.getFirstName() + " " + account.getLastName() + 
                ".  Balance: " + account.getBalance());
    // Or override Account's toString() method and do System.out.println(account.toString()) 
    }