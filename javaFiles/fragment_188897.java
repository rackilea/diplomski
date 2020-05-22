@Entity(name = "auth_role")
public class Role {

  @Id
  @Column
  private String id;

  @Column(nullable = false, unique = true)
  /**
   *unique and transformed to GrantedAuthority,can be used in Spring expression hasRole, etc
  **/
  private String name;


  @Column(nullable = true)
  private String description;
}