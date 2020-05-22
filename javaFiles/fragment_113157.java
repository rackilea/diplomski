@Entity
public class Address {    
    @Id @GeneratedValue
    private Long id;    
    private String street_1;
    private String street_2;    
    private String city;
    private String state;
    private String zipcode;
    private String country;

    @OneToOne(mappedBy = "address")
    private Customer customer;

    //getters, setters, and constructors
}

@Entity
public class Customer {

    @Id @GeneratedValue
    private Long id;  
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL) @JoinColumn( name = "address_id" )
    private Address address;

    //getters, setters, and constructors
}