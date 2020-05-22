@Entity
public class UserRole {
  @Id
  @GeneratedValue
  private long id;

  @NaturalId
  private User user;
  @NaturalId
  private Role role;
}