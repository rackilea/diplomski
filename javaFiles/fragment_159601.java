@Entity
@Table(name = "user")
public class User {

    //...

    @Column(name = "user_password")
    @JsonIgnore
    private String password;