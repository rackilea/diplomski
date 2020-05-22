while(fileScan.hasNext()){
    String fName = fileScan.next();
    String lName = fileScan.next();
    int age = fileScan.nextInt();
    String phoneNumber = fileScan.next();

    Client client = new Client(....); //use info above

    accounts[numAccounts].setClient(client);
    accounts[numAccounts].setBalance(fileScan.nextDouble());
    accounts[numAccounts].setAccountNum(fileScan.nextInt());

    numAccounts++;
    System.out.println(accounts[numAccounts]);
}