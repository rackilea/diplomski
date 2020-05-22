@XmlRootElement(name = "range")
@XmlAccessorType(XmlAccessType.FIELD) 
public class RangeClass {

    @XmlPath("lower/@value")
    private int lower;

    @XmlPath("higher/@value")
    private int higher;

}