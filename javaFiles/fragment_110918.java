@Entity
public class User extends Model {
  @Id
  @Column(name = "user_index")
  private int id;

  @Column(name = "user_first_name")
  private String firstName;

  [...]

  @OneToMany(mappedBy = "book_owner_index")
  private List<Book> books;

  public static Finder<Integer, User> find = new Finder<Integer, User>(Integer.class, User.class);

  [...]
}