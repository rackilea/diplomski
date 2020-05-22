//....getter, setter of Person class
@JsonIgnore
public List<Event> getEvents() {
    return events;
}

@JsonProperty("events")
public Event[] getEventsArr() {
    return events.toArray(new Event[0]);
}