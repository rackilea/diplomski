@Entity
@Table(name="items")
    public class Item implements Serializable{
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "uuid", unique = true)
    protected String itemUUID;

    @Column(name = "name")
    protected String name;

    @Column(name = "description")
    protected String description;

    @OneToMany(mappedBy="item", cascade = CascadeType.ALL, orphanRemoval=true)
    private Set<UserItem> users = new HashSet<UserItem>();