@Entity
public class Role {
    private Long id;
    private boolean enabled;
}     

@Entity
public class User {
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    @Where(clause = "enabled = true")
    private Set<Role> roles = new LinkedHashSet<>(0);
}