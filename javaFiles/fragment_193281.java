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

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
}