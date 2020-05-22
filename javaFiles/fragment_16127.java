public class Transaction {

    @ManyToOne
    @JoinColumn(name = "FROM_ACC_COLUMN", referencedColumnName = "account_id")
    private Account fromAcc;

    @ManyToOne
    @JoinColumn(name = "TO_ACC_COLUMN", referencedColumnName = "account_id")
    private Account toAcc;

}