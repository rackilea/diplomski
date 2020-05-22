public class AccountIdentifier {
    public String accountNumber;
    public String customerName;

    public AccountIdentifier(String accountNumber, String customerName) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
    }
    public int hashCode() {
        return (accountNumber+"#"+customerName).hashCode();
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof AccountIdentifier)) return false;
        else {
            AccountIdentifier id = (AccountIdentifier)obj;
            return accountNumber.equals(id.accountNumber) && customerName.equals(id.customerName);
        }
    }
}