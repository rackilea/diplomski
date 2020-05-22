class Account {

    private double balance;
    private int accNumber;
    private String owner;

    public Account(Double bal, int accNo, String own) {
        // TODO Auto-generated constructor stub
        this.balance = bal;
        this.accNumber = accNo;
        this.owner = own;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

}