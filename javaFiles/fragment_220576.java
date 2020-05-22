import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
    @XmlElement
    private Address address;
     .
     .
}

@XmlRootElement
public class Address {
    .
    .
}