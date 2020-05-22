@Entity
@Table
public class User {

    @Id
    @GeneratedValue
    private Long pid;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Role> roles;

}

@Entity
@Table
public class Role {

    @Id
    private Long pid;

    @Column
    private String name;

}