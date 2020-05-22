@Entity
@Table(name = "VEHICLE")
@XmlRootElement(name = "vehicle")
public class Vehicle {

    // other fields here

    @OneToMany(mappedBy = "vehicle")
    Set<VehicleImage> vehicleImages;

}