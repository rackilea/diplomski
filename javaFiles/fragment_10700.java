else if(source.equals("Add new account")) {
//*************         Output
    //use constructor below if you have a default constructor aka no paramaters
    CheckingAccount account = new CheckingAccount();
    //now that you have object linked to account, you can use setters
    accountName = JOptionPane.showInputDialog("Enter the account name: ");
    //set the name
    account.setName(accountName);

    String strInitialBalance = JOptionPane.showInputDialog("Enter your initial
    balance: ");
    initialBalance = Double.parseDouble(strInitialBalance);
    //set the balance
    account.setBalance(initialBalance);

    //dont make a new object now as you did before..just add the object to your arraylist
    dataStore.add(index++, account);

}