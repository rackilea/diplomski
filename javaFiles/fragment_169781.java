@Entity
@Table(name = "users")
public class User {
    // other fields

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch=FetchType.EAGER)
    @JsonManagedReference
    private List<Address> addresses;

    // getters, setters, constructors etc.

    // the remove method
    public void removeAddress(Address address) {
        address.setUser(null);
    }
}