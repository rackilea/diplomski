@Document
public class EmlMessage extends Message {

    private String eventType;
    private String emlPath;

    public EmlMessage() {
        super();
    }

    public EmlMessage(String id,
                      WatchEvent.Kind<Path> eventType,
                      StatusType statusType,
                      String emlPath) {

        super(id, statusType);
        this.eventType = eventType.name();
        this.emlPath = emlPath;
    }

    public EmlMessage(String id,
                      String eventType,
                      StatusType statusType,
                      String emlPath) {

        super(id, statusType);
        this.emlPath = emlPath;
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(WatchEvent.Kind<Path> eventType) {
        this.eventType = eventType.name();
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEmlPath() {
        return emlPath;
    }

    public void setEmlPath(String emlPath) {
        this.emlPath = emlPath;
    }