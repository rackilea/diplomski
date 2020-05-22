@Entity(value="customers", noClassnameStored=false)
public class Customer {

    @Id
    private ObjectId id;
    private String Name;
    private int social;
    private long balance;
}


public class CustomerInfo extends Customer {
    private Address address;
    private PhoneNumber phoneNumber;
}