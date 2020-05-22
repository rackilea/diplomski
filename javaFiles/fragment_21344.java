@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = {@JoinColumn(name = "cat_id")}, inverseJoinColumns = @JoinColumn(name = "inverse_cat_id"))
    private Set<Category> children = new HashSet<>();
    }