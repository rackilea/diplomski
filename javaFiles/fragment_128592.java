@Entity
public class Client {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    @Embedded
    private Address address;
}

@Embeddable
public class Address {
    private int houseNumber;
    private String streetName;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}