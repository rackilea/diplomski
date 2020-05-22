@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class OperationQueue {

    @XmlElements({
            @XmlElement(name = "pick", type = Pick.class),
            @XmlElement(name = "place", type = Place.class),
            @XmlElement(name = "goTo", type = GoTo.class),
            @XmlElement(name = "toDo", type = ToDo.class),
    })
    public List<QueueItem> item;

}