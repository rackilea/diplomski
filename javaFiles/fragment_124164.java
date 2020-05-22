import java.util.Scanner;
public class BankApp {
public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Bank myBank = new Bank();

    int user_choice = 2;

    do {
        //display menu to user
        //ask user for his choice and validate it (make sure it is between 1 and 6)
        System.out.println();
        System.out.println("1) Open a new bank account");
        System.out.println("2) Deposit to a bank account");
        System.out.println("3) Withdraw to bank account");
        System.out.println("4) Print short account information");
        System.out.println("5) Print the detailed account information including last transactions");
        System.out.println("6) Quit");
        System.out.println();
        System.out.print("Enter choice [1-6]: ");
        user_choice = s.nextInt();
        switch (user_choice) {
            case 1: System.out.println("Enter a customer name");
                    String cn = s.next();
                    System.out.println("Enter a opening balance");
                    double d = s.nextDouble();
                    System.out.println("Account was created and it has the following number: " + myBank.openNewAccount(cn, d));
                    break;
            case 2: System.out.println("Enter a account number");
                    int an = s.nextInt();
                    System.out.println("Enter a deposit amount");
                    double da = s.nextDouble();
                    myBank.depositTo(an, da);
                    break;
            case 3: System.out.println("Enter a account number");
                    int acn = s.nextInt();
                    System.out.println("Enter a withdraw amount");
                    double wa = s.nextDouble();
                    myBank.withdrawFrom(acn, wa);
                    break;
            case 4: System.out.println("Enter a account number");
                    int anum = s.nextInt();
                    myBank.printAccountInfo(anum);
                    break;
           case 5:  System.out.println("Enter a account number");
                    anum = s.nextInt();
                    myBank.printTransactionInfo(anum);
                    break;
          default: System.out.println("Invalid option. Please try again.");

        }
}
while (user_choice != '6');
}

static class Bank {
private BankAccount[] accounts;     // all the bank accounts at this bank
private int numOfAccounts;      // the number of bank accounts at this bank

    //Constructor: A new Bank object initially doesnâ€™t contain any accounts.
public Bank() {
    accounts = new BankAccount[100];
    numOfAccounts = 0;
    }

// Creates a new bank account using the customer name and the opening balance given as parameters
// and returns the account number of this new account. It also adds this account into the account list
// of the Bank calling object.
public int openNewAccount(String customerName, double openingBalance) {

    BankAccount b = new BankAccount(customerName, openingBalance);
    accounts[numOfAccounts] = b;
    numOfAccounts++;
    return b.getAccountNum();
}

// Withdraws the given amount from the account whose account number is given. If the account is
// not available at the bank, it should print a message.
public void withdrawFrom(int accountNum, double amount) {
    for (int i =0; i<numOfAccounts; i++) {
        if (accountNum == accounts[i].getAccountNum()  ) {
            accounts[i].withdraw(amount);
            System.out.println("Amount withdrawn successfully");
            return;
        }
    }
    System.out.println("Account number not found.");
    }

// Deposits the given amount to the account whose account number is given. If the account is not
// available at the bank, it should print a message.
public void depositTo(int accountNum, double amount) {
    for (int i =0; i<numOfAccounts; i++) {
        if (accountNum == accounts[i].getAccountNum()  ) {
            accounts[i].deposit(amount);
            System.out.println("Amount deposited successfully");
            return;
        }
    }
    System.out.println("Account number not found.");
}

// Prints the account number, the customer name and the balance of the bank account whose
// account number is given. If the account is not available at the bank, it should print a message.
public void printAccountInfo(int accountNum) {
    for (int i =0; i<numOfAccounts; i++) {
                if (accountNum == accounts[i].getAccountNum()  ) {
                    System.out.println(accounts[i].getAccountInfo());
                    return;
                }
            }
    System.out.println("Account number not found.");
}

public void printTransactionInfo(int accountNum) {
    for (int i =0; i<numOfAccounts; i++) {
                if (accountNum == accounts[i].getAccountNum()  ) {
                    System.out.println(accounts[i].getAccountInfo());
                    System.out.println("Last transaction: " + accounts[i].getTransactionInfo(accounts[i].getNumberOfTransactions()-1));
                    return;
                }
            }
    System.out.println("Account number not found.");
}


// Prints the account number, the customer number and the balance of the bank account whose
// account number is given, together with last n transactions on that account. If the account is not
// available at the bank, it should print a message.
public void printAccountInfo(int accountNum, int n) {
    for (int i =0; i<numOfAccounts; i++) {
                        if (accountNum == accounts[i].getAccountNum()  ) {
                            System.out.println(accounts[i].getAccountInfo());
                            System.out.println(accounts[i].getTransactionInfo(n));
                            return;
                        }
                    }
    System.out.println("Account number not found.");
    }

}
    static class BankAccount{

       private int accountNum;
       private String customerName;
       private double balance;
       private double[] transactions;
       private String[] transactionsSummary;
       private int numOfTransactions;
       private  static int noOfAccounts=0;

       public String getAccountInfo(){
           return "Account number: " + accountNum + "\nCustomer Name: " + customerName + "\nBalance:" + balance +"\n";
       }

       public String getTransactionInfo(int n)
       {
            String transaction = transactionsSummary[n];
            if (transaction == null) {
                return "No transaction exists with that number.";
            }
            else {
                return transaction;
            }
        }

       public BankAccount(String abc, double xyz){
         customerName = abc;
         balance = xyz;
         noOfAccounts ++;
         accountNum = noOfAccounts;
         transactions = new double[100];
         transactionsSummary = new String[100];
         transactions[0] = balance;
         transactionsSummary[0] = "A balance of : $" + Double.toString(balance) + " was deposited.";
         numOfTransactions = 1;
       }

    public int getAccountNum(){
        return accountNum;
    }

    public int getNumberOfTransactions() {
        return numOfTransactions;
    }

    public void deposit(double amount){

        if (amount<=0) {
            System.out.println("Amount to be deposited should be positive");
        } else {
            balance = balance + amount;
            transactions[numOfTransactions] = amount;
            transactionsSummary[numOfTransactions] = "$" + Double.toString(amount) + " was deposited.";
            numOfTransactions++;
        }
    }
    public void withdraw(double amount)
    {
        if (amount<=0){
             System.out.println("Amount to be withdrawn should be positive");
         }
        else
        {
            if (balance < amount) {
                System.out.println("Insufficient balance");
            } else {
                balance = balance - amount;
                transactions[numOfTransactions] = amount;
                transactionsSummary[numOfTransactions] = "$" + Double.toString(amount) + " was withdrawn.";
                numOfTransactions++;
            }
        }
    }

    }//end of class
}