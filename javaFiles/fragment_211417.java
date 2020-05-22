@Entity
@Table(name = "login", catalog = "friends", uniqueConstraints =
@UniqueConstraint(columnNames = "username"))
public class Login implements java.io.Serializable{

   private static final long serialVersionUID = 1L;
   @Id
   @Column(name = "username", unique = true, nullable = false, length = 50)
   private String username;
   @Column(name = "password", nullable = false, length = 250)
   private String password;
}