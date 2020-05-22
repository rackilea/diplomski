@XmlRootElement(name = "privileges")
@XmlAccessorType(XmlAccessType.FIELD)
public class Privileges {

    @XmlElement(name="privilege")
    private Privilege privilege;

    //Getters and setters

}

@XmlAccessorType(XmlAccessType.FIELD)
public class Privilege{

    @XmlAttribute(name = "number_residents")
    private Integer numberResidents;
    @XmlAttribute(name = "value")
    private String value;
    @XmlValue
    private String privilege;

    //getters and setters

}