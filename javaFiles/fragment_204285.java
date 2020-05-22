@Entity
public class UserDetails {
    /* ... */

    @OneToMany(mappedBy = "user")
    private List<UserVehicle> vehicles;
}

@Entity
public class Vehicle {
    /* ... */
}

@Entity
public class UserVehicle {
    /* ... */

    @ManyToOne
    private UserDetails user;

    @ManyToOne
    private Vehicle vehicle;

    @Basic
    private String someString;
}