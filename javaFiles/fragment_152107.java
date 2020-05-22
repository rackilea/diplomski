@XmlAccessorType(XmlAccessType.FIELD)
public class ApiObject {

    @XmlAnyElement(lax = true)
    private List<Object> anything;

    @XmlElement(name= "last-name", namespace = "http://www.example.com/publications/api")
    private String lastName;
    @XmlElement(name = "first-name", namespace = "http://www.example.com/publications/api")
    private String firstName;
    @XmlElement(name = "email-address", namespace = "http://www.example.com/publications/api")
    private String emailAddress;
}