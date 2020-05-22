@Entity
@Table(name = "VEHICLE_IMAGE")
public class VehicleImage{

    // other fields here

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="VEHICLE_ID", referencedColumnName = "ID")
    Vehicle vehicle;

}