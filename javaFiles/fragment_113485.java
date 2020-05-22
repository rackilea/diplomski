@Entity
public class Account {

    @Id
    private long id;

    @Version
    private long version;

    @Basic
    private BigDecimal balance;
}