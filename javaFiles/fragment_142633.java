@Entity
@Table(name = "my_table")
public class MyTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "test_id")
    private Long testId;

    @OneToMany(fetch = FetchType.EAGER, 
               cascade = CascadeType.ALL)
    @JoinColumn(name = "parentId")
    private Set<MyTable> children = new HashSet<MyTable>();

    //getters and setters
}