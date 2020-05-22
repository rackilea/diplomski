@NodeEntity
public class MyEvent
    {

    @GraphId
    private Long       nodeId;

    @RelatedToVia(type = "INVITED_TO")
    @Fetch
    Set<EventResponse> eventResponse;

    }