public class Feedback {

    private long eventId;

    @JsonProperty("event_id")
    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }
}