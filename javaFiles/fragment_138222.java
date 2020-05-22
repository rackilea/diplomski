@RelationshipEntity(type = "INVITED_TO")
public class EventResponse
    {

    @GraphId
    private Long    nodeId;

    @StartNode
    MyEvent event;

    @EndNode
    User    user;

    }