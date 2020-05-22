public class Transaction {

    private int transactionId;
    private String transactionType;
    private double transactionAmount;
    private double moneyBeforeTransaction;
    private double moneyAfterTransaction;

    public Transaction(){}

    public Transaction(int transactionId,String transactionType,double transactionAmount, double moneyBeforeTransaction){
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.moneyBeforeTransaction = moneyBeforeTransaction;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public double getMoneyBeforeTransaction() {
        return moneyBeforeTransaction;
    }

    public void setMoneyBeforeTransaction(double moneyBeforeTransaction) {
        this.moneyBeforeTransaction = moneyBeforeTransaction;
    }

    public double getMoneyAfterTransaction() {
        return moneyAfterTransaction;
    }

    public void setMoneyAfterTransaction(double moneyAfterTransaction) {
        this.moneyAfterTransaction = moneyAfterTransaction;
    }

    //Override the toString() method of String ? 
    public String toString(){
        return "Transaction ID : " + this.transactionId +
                " Transaction Type : " + this.transactionType +
                " Transaction Amount : " + this.transactionAmount +
                " Money Before Transaction : " + this.moneyBeforeTransaction + 
                " Money After Transaction : " + this.moneyAfterTransaction;
    }

}