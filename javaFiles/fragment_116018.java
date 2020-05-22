public class CalendarFeed {
    public enum FeedType { GCAL, EVENT };
    @JsonIgnore
    private Member owner;
    private String name;
    private String value;
    @JsonIgnore
    private FeedType type;
}