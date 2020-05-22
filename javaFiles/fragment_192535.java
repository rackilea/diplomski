@Embeddable
public class EventID {
    public int eventID;
    public int sourceID;
}

@Entity
public class Event {
    @EmbeddedId
    public EventID id;

    @OneToMany(mappedBy="event")
    public Collection<Meeting> meetings;
}

@Embeddable
public class MeetingID {
    public EventID eventID; // corresponds to ID type of Event
    public int meetingID;
}

@Entity
public class Meeting {
    @EmbeddedId
    public MeetingID id;

    @MapsId("eventID")
    @JoinColumns({
        @JoinColumn(name="EventID", referencedColumnName="EventID"),
        @JoinColumn(name="SourceID", referencedColumnName="SourceID")
    })
    @ManyToOne
    public Event event;
}