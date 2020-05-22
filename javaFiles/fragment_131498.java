@Entity
public class Customer extends BaseEntity {

    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private final Set<Address> addresses = new HashSet<Address>();

    // No setter, only a getter which returns an immutable collection
    public Set<Address> getAddresses() {
        return Collections.unmodifiableSet(this.addresses);
    }

    public void addAddress(Address address) {
        address.setCustomer(this);
        this.addresses.add(address);
    }

}