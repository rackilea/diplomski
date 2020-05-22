public class TransactionsRecord extends UpdatableRecordImpl<TransactionsRecord> 
    implements Record20<...> {

    public void setAccount(String value) {
        set(0, value);
    }

    public String getAccount() {
        return (String) get(0);
    }

    public void setAddress(String value) {
        set(1, value);
    }

    public TransactionsRecord() {
        super(Transactions.TRANSACTIONS);
    }

    public TransactionsRecord(String account, String address, BigDecimal amount, ...) {
        super(Transactions.TRANSACTIONS);

        set(0, account);
        set(1, address);
        set(2, amount);
        ...
    }

    public BigDecimal getAmount() {
        return (BigDecimal) get(2);
    }

    public String getAddress() {
        return (String) get(1);
    }

    public void setAmount(BigDecimal value) {
        set(2, value);
    }

    public void setBlockhash(String value) {
        set(4, value);
    }

    ...