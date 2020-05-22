@Entity
@Table(name = "MyOrder")
public class MyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "myOrder", cascade = CascadeType.All)
    private List<Products> productses;