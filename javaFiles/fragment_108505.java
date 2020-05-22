@Embeddable
public class Coordinates {

    @Column(name = "device_event_lat")
    private Double lat;

    @Column(name = "device_event_lng")
    private Double lng;

    protected Coordinates(){
        //JPA requires no-arg constructor
    }

    public Coordinates(Double lat, Double lng) {
        super();
        this.lat = lat;
        this.lng = lng;
    }
}


@Entity
@Table(name="t_device_event")
public class DeviceEvent {

    //other fields ommitted

    @Embedded
    private Coordinates coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}