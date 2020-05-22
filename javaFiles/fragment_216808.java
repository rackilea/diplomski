@Table
@Entity
@EntityListeners({EntityListener.class})
class Model {
  @Id
  @Column(updatable = false)
  @GeneratedValue
  private int id;

  private String password;

  private String username;

}