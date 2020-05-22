public class BankAccount {

    private int accountId;
    private String holderName;
    private String holderAddress;
    private String openDate;
    private double currentBalance;

    private List<Transaction> transactions = new ArrayList<Transaction>();

    //Provide Blank Constructor
    public BankAccount(){}

    //Constructor with an arguments.
    public BankAccount(int accountNum, String holderNam,double currentBalance, String holderAdd,String openDate) {
            this.accountId = accountNum;
            this.holderName = holderNam;
            this.holderAddress = holderAdd;
            this.openDate = openDate;
            this.currentBalance = currentBalance;
    }

    // Always Provide Setter and Getters
    public int getAccountId() {
        return accountId;
    }
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public String getHolderName() {
        return holderName;
    }
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    public String getHolderAddress() {
        return holderAddress;
    }
    public void setHolderAddress(String holderAddress) {
        this.holderAddress = holderAddress;
    }
    public String getOpenDate() {
        return openDate;
    }
    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }
    public double getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String toString(){
        return "\nAccount number: " + accountId + "\nHolder's name: " + holderName + "\nHolder's address: " + holderAddress + "\nOpen Date: " + openDate + "\nCurrent balance: " + currentBalance;
    }

}