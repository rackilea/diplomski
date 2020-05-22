Public class MainSample {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        BankProcess bankProcess = new BankProcess();
        TransactionProcess transactionProcess = new TransactionProcess();

        //Adding new Bank & Bank Account

        // We Already Declare the information about The Back.
        Bank bank = new Bank(1,"GTS");
        BankAccount bankAccount = null;


        //accepting bankAccount informations.

        System.out.print("Account Id: ");
        int accountId = scan.nextInt();

        System.out.print("Holder Name: ");
        String holderName = scan.next();

        System.out.print("Opening Balance: ");
        Double openingBalance = scan.nextDouble();

        System.out.print("Holder Address: ");
        String holderAddress = scan.next();

        System.out.print("Open Date: ");
        String openDate = scan.next();

        //Set the information gathered to BankAccount.
        bankAccount = new BankAccount(accountId,holderName,openingBalance,holderAddress,openDate);

        //Call the Method of BankProcess openNewAccount
        //then set the New|Lastest list of bankaccounts
        bank.setAccounts(bankProcess.openNewAccount(bank.getAccounts(), bankAccount));


        //Here is sample Transaction
        //Deposit.
        System.out.println("Enter Deposit Amount");
        Double depositAmount = scan.nextDouble();

        //This will Process the Transaction of user
        transactionProcess.deposit(bankAccount, depositAmount);

        //Withdraw
        System.out.println("Enter Withdraw Amount");
        Double withdrawAmount = scan.nextDouble();

        transactionProcess.withdraw(bankAccount, withdrawAmount);

        //END


        //this will be Executed After you successfully finished all process 
        //this will provide the list of bankAccount in a certain bank.
        for(Map.Entry<Integer, BankAccount> bankAccounts : bank.getAccounts().entrySet()){
            //Use the toString method of BankAccount, this will Provide all the information of user
            System.out.println(bankAccounts.getValue().toString());
        }

        //This will output the List of the Transactions done by the Current BankAccount(User)
        for(Transaction transaction : bankAccount.getTransactions()){
            System.out.println(transaction.toString());
        }


    }

}