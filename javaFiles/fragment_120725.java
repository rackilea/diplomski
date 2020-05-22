@XmlRootElement(name = "range")
@XmlAccessorType(XmlAccessType.FIELD) 
public class RangeClass {

    @XmlElement
    private int lower;

    @XmlElement
    private int higher;

}