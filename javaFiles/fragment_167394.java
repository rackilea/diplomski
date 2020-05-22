@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String name;
    private final String email;

    public User(String name, String email) {
      this.name = name;
      this.email = email;
    }

    public void setId(long id) {
      this.id = id;
    }

    public long getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public String getEmail() {
      return email;
    }
}