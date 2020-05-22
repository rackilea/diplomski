@Entity(name = "Role")
public class Role {
    @ManyToMany(mappedBy = "roles")
    private Set<AppUser> appUsers;
    ...

}

@Entity(name = "Group")
public class Group {
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "GROUP_APPUSER", joinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"))
    private Set<AppUser> appUsers;
    ...
}

@Entity(name = "AppUser")
public class AppUser {
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "APPUSER_ROLE", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"))
    private Set<Role> roles;
    ...

    @ManyToMany(mappedBy = "appUsers")
    private Set<Group> groups;
    ...

}