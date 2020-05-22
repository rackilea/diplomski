@Embeddable
public class AttendingID implements Serializable {

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "users_userID", referencedColumnName = "userID")
    private User user;

    @ManyToOne(targetEntity = Event.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "events_eventID", referencedColumnName = "eventID")
    private Event event;

    ...
    // setters, getters, constructors, equal and hash ...
}