@Entity
public class Book extends Model {
  @Id
  @Column(name = "book_index")
  private int id;

  @Column(name = "book_name")
  private String name;

  @Column(name = "book_condition")
  private String condition;

  [...]

  @ManyToOne
  @JoinColumn(name = "book_owner_index", referencedColumnName = "user_index")
  private User owner;

  [...]
}