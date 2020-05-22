@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FIRST_NAME") //Attributes in the entity
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ADDRESS")
    private String address;

    @ManyToMany(mappedBy = "customer")
    @JoinTable(name = "customer_address", 
        joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"))
    private List<Address> addresses;
}

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "STREET_NAME") //Attributes in the entitiy
    private String streetName;

    @Column(name = "HOUSE_NUMBER")
    private int houseNumber;

    @ManyToMany(mappedBy = "customer")
    @JoinTable(name = "customer_address", 
        joinColumns = @JoinColumn(name = "address_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
    private List<Customer> customer;
}