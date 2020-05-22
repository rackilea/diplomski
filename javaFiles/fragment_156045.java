@Embeddable
public class ScheduleOwner implements Serializable{

    @MapsId("id")
    @ManyToOne(cascade = CascadeType.ALL)
    Company c;

    @MapsId("id")
    @ManyToOne(cascade = CascadeType.ALL)
    Employee e;
}