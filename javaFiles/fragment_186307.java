@Embeddable
public class AttendingID implements Serializable {

    @Column(name = "users_userID")
    private Integer userID;

    @Column(name = "events_eventID")
    private Integer eventID;

    ...
    // setters, getters, constructors, equal and hash ...
}