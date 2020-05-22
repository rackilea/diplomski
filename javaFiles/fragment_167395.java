@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String name;
    public String email;

    public User() {}

    public User(String name, String email) {
      this.name = name;
      this.email = email;
    }
}