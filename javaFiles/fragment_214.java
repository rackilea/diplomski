@Entity
public class BankAccount implements Serializable {

    @OneToOne( optional = false, fetch = FetchType.LAZY, mappedBy = "bankAccount")
    private User user;
    //...
}