public class Account {
    private String accName;
    private String accId;
    private int balance;

    Account() {
        System.out.println("This is an empty constructor.");
    }

    Account(String name) {
        accName = name;
        System.out.println("This is an valued constructor.");
    }

    public static void main(String[] args) {
        Account a1 = new Account("raff");
    }
}