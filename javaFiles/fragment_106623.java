import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(namespace="http://www.example.com")
@XmlType(namespace="http://www.example.com")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

    @XmlAttribute
    private int id;

    @XmlElement(namespace="http://www.example.com")
    private String firstName;

    @XmlElement(namespace="http://www.example.com", nillable=true)
    private String lastName;

    @XmlElement(namespace="http://www.example.com")
    private List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

}