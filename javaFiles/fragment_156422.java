@Entity
public class BrideAccount {

    @ID
    Integer id;

    @Column(name = "WEDDING_DATE")
    private Date weddingDate;

    Account account;
}