class Account {
    // fields representing state of Account
    private int number;
    private double amount; //again in real world double would not be best choice
                           //and you would use something like BigDecimal

    // getters and setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // constructor
    public Account(int number, double amount) {
        this.number = number;
        this.amount = amount;
    }
}