@XmlRootElement(name = "status")
@XmlType(propOrder = { "code", "message" })
public class InvalidUser {
    private int code;
    private String message;
    ...set/get
}