//Switch statement to direct program based on option entered by user
    switch (option) {

        //create a new checking account
        case 1:
        CheckingAccount c1 = new CheckingAccount(id, balance, annualInterestRate); //Create a new CheckingAccount object
        id++; //increment id by 1
        account.add(c1); //add the new CheckingAccount to the Arraylist accounts
        break;

        //create a new savings account
        case 2:
        SavingsAccount s1 = new SavingsAccount(id, balance, annualInterestRate); //create a new SavingsAccount object
        id++; //increment id by 1
        account.add(s1); //add the new SavingsAccount to the ArrayList accounts
        break;

        //delete an existing account
        case 3:
        //c1.displayAccounts();
        //c1.deleteAccount();
        break;