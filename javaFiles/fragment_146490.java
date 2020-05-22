@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class VerifyAttr {
    @XmlElement(name="VerifyAttr", type=VerifyAttr.class)
    private ArrayList<VerifyAttr> va;

    @XmlElement(name="VerifyXpath", type=VerifyXpath.class)
    private ArrayList<VerifyXpath> vx;

    // some other fields
    //..getter and setters
}