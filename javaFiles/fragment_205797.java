@Entity
@Table(name = "users")
public class User implements Serializable, Annotation {

    @Id
    @GeneratedValue(generator = "system-uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "uuid", unique = true)
    protected String userUUID;

    @Column(name = "username")
    protected String username;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval=true)
    private Set<UserItem> items = new HashSet<UserItem>();
}