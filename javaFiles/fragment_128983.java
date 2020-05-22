@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public User() {}

    public User(User user) {
        this.id = user.getId();
        this.name = user.getName();
        // … the same for all properties.
    }
}