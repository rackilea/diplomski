@Entity
public class User {
  int id;
  String username;
  String password;

  @ManyToMany
  Set<Role> roles = new HashSet<>();
}