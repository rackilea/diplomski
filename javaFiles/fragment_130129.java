@XmlRootElement(name = "Message")
public class Message {
    @XmlElement(required = true, name = "Version") private String version;
    private RequestContainer request;
    private ResponseContainer response;
    private NotificationContainer notification;

    @XmlElementRef(required = false)
    public Request getRequest() {
        return request;
    }

    @XmlElementRef(required = false)
    public Response getResponse() {
        return response;
    }

    @XmlElementRef(required = false)
    public Notification getNotification() {
        return notification;
    }
}