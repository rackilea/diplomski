public class Bank {

    private int bankId;
    private String bankName;
    private TreeMap<Integer,BankAccount> bankAccounts = new TreeMap<Integer,BankAccount>();

    public Bank(){}

    public Bank(int bankId,String bankName){
        this.bankId = bankId;
        this.bankName = bankName;
    }

    public int getBankId() {
        return bankId;
    }
    public void setBankId(int bankId) {
        this.bankId = bankId;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public TreeMap<Integer, BankAccount> getAccounts() {
        return bankAccounts;
    }
    public void setAccounts(TreeMap<Integer, BankAccount> accounts) {
        this.bankAccounts = accounts;
    }
}