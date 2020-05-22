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
    @WhereJoinTable(clause = "now() between valid_from and valid_until")
    private Set<Role> roles = new LinkedHashSet<>(0);
}

and association table has validity attributes, something like 

CREATE TABLE USER_ROLE {
    ID NUMBER NOT NULL,
    USER_ID NUMBER NOT NULL,
    ROLE_ID NUMBER NOT NULL,
    VALID_FROM DATETIME,
    VALID_UNTIL DATETIME
}