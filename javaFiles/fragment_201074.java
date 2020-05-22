class Driver {


@Id
Long id;

@OneToOne(mappedBy="driver")
 Vehicle vehicle;

@PreRemove
public void preRemove() {
    vehicle.setDriver(null);
}

// getters and setters...


}

class Vehicle{

    @Id
    Long id;

    @OneToOne
    Driver driver;

    // getters and setters
}