public class Main {
    public static void main(String[] args) {
        Customer jack = new Customer("Jack", "Jackson");
        jack.setBalance(9001);

        Customer john = jack.clone();
        john.setBalance(1337);

        System.out.println("Jack's balance (name = " + jack.getFirstname()
                + "): " + jack.getBalance());
        System.out.println("John's balance (name = " + john.getFirstname()
                + "): " + john.getBalance());
    }
}

class Customer {
    private String firstname, lastname;
    private int balance;

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        balance = 500;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int b) {
        this.balance = b;
    }

    protected Customer clone() {
        Customer newCustomer = new Customer(getFirstname(), getLastname());
        newCustomer.setBalance(getBalance());
        return newCustomer;
    };
}