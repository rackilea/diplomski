@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountSyncResponse  {

    @XmlElement(name = "Result")
    private String result;

    @XmlElement(name = "Value")
    private String value;

    // Default constructor, getters and setters
}