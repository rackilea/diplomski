@Data
@Entity
@Table(name = "users", uniqueConstraints={ @UniqueConstraint(columnNames={"username"})})
public class User {

    @Id
    @CustomEmailValidator
    @Size.List ({
            @Size(min=5, message="The field must be at least {min} characters"),
            @Size(max=100, message="The field must be less than {max} characters")
    })
    private String username;

    @Basic
    @Column(name = "enabled", columnDefinition = "BIT", length = 1)
    private boolean enabled;

    @@JsonManagedReference
    @OneToMany(cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "user")
    @Column(nullable = false)
    private List<Authority> authorities = new ArrayList<>();
}