@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "domain")
public class Response {

    @XmlElement
    private String name;

    @XmlAnyElement(lax=true)
    private Object owner;

    private String ownerSimple;

    @XmlTransient
    private Owner ownerComplex;