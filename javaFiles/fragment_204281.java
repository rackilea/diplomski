@Entity
public class UserDetails {
    /* ... */

    @ManyToMany
    @JoinTable(name = "user_vehicle",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    private List<Vehicle> vehicles;
}

@Entity
public class Vehicle {
    /* ... */
}