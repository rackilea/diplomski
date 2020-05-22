@Entity
@Table
public class User extends BusinessObject {

    ... 

    // This end is the owner of the association
    @ManyToMany
    @JoinTable(name= "user_role",
               joinColumns = {@JoinColumn(name="user_id")},
               inverseJoinColumns = {@JoinColumn(name="role_id")})  
    private Set<Role> roles = new HashSet<Role>();      
    ... 
}

@Entity
@Table
public class Role extends BusinessObject {
    ...

    // This end is not the owner. It's the inverse of the User.roles association
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<User>();          

    ... 
}