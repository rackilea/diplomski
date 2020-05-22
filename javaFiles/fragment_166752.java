public class Account {

    /* 
     * If you know about private members, declare them private.
     * Probably you should because the exercise asks for getter and setter.
     */

    /* private */ String name;
    /* private */ double balance;

    public Account() {
        // Useless: Java calls automatically the superclass constructor.
        // super(); 

        /*
         * These are useless too, because Java initializes the class
         * members to 0, false and null.
         * However, this is what the exercise is asking you to do.
         */

        name = null;
        balance = 0;
    }

    public Account(String name, double balance) {
        // take advantage of setters
        setName(name);
        setBalance(balance);
    }

    public void setName(String name) { this.name = name; }

    public void setBalance(double balance) {
        if (balance < 0)
            throw new IllegalArgumentException("balance must be non-negative.");
        this.balance = balance;
    }

    public String getName() { return name; }

    public double getBalance() { return balance; }

}