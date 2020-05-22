@Entity
@Table(name = "user")
public class User extends AbstractPersistable<Long>{


    private static final long serialVersionUID = 1L;


    @Column(name = "USER_NAME", unique = true)
    private String username;
    @Column(name = "PASSWORD")
    private String password;



    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name="user_roles",
        joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
        inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
    )
    private List<Role> roles;



    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public List<Role> getRoles() {
        return roles;
    }



    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }



    public User(String username, String password, List<Role> roles) {
        super();
        this.username = username;
        this.password = password;
        this.roles = roles;
    }



    public User() {
        super();
    }
}