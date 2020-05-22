@Entity
public class Invoice extends AbstractEntity {

    @ManyToOne()
    @JoinColumn(name="user_id", updatable=false)
    private User user;
}