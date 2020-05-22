@MappedSuperclass
public class Vehicle {
    @Id
    @GeneratedValue
    Long id;
    Long maxSpeed;
    String make;
    String model;
}