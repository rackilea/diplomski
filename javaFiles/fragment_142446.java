@Entity
public class UserItem extends Model {
    @Id
    public Long id;

    @ManyToOne
    @JoinColumn(name = "user")
    public User user;

    @ManyToOne
    @JoinColumn(name = "item")
    public Item item;

    public Date date;

    ...
}