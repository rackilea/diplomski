@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "owner")
public class Owner {

    @XmlElement
    int id;

    @XmlElement
    String fname;

    @XmlElement
    String lname;