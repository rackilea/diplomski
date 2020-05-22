@Entity
public class UserDetails {
    /* ... */

    @OneToMany(mappedBy = "user")
    private List<Vehicle> vehicles;
}

@Entity
public class Vehicle {
    /* ... */

    @ManyToOne
    private UserDetails user;
}