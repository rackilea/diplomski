@Entity
    @Table(name="user_table")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;

    @Column(name="full_name")
    private String fullName;

    @OneToMany(cascade=CascadeType.REMOVE, fetch=FetchType.LAZY)
    private Set<Profession> prof;  
    // getters and setters
    }