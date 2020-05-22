class Acc {
    public static int noOfAccounts;
    public static double totalBalance;

    public Acc(double balance) {
        //increase the number of accounts
        Acc.noOfAccounts++;
        //add the balance to totalBalance
        Acc.totalBalance += balance;
    }
}


public class Helper {

    //test
    public static void main(String[] args) {

        Acc aOne = new Acc(15.4);
        System.out.println("Acc.noOfAccounts = " + Acc.noOfAccounts);
        System.out.println("Acc.totalBalance) = " + Acc.totalBalance);

        Acc aTwo = new Acc(100.0);
        System.out.println("Acc.noOfAccounts = " + Acc.noOfAccounts);
        System.out.println("Acc.totalBalance) = " + Acc.totalBalance);

    }
}