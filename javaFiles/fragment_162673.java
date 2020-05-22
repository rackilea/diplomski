public class Main {

    public static void main(String[] args) {

        // create an Object
        BankAccount ba = new BankAccount();
        // use some Methods
        System.out.println(ba.getBalance()); 
        ba.deposit(500);
        System.out.println(ba.getBalance());
        ba.withdraw(250);
        System.out.println(ba.getBalance());
    }
}