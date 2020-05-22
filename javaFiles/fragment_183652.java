@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "person")
    private String person;
    @Column(name = "mail")
    private String mail;
    private int packFlg;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<MainOrder> mainOrder;

    // generate getter and setter here
}