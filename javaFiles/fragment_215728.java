@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Part {

    @XmlElement(name="Part_Number");
    private String partNo;

    @XmlElement(name="part")
    private List<Part> parts;

}