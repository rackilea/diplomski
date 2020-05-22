@XmlRootElement(name = "icns")
@XmlAccessorType(XmlAccessType.FIELD)
public class IcnList {

    @XmlElement(required = true)
    private List<IcnElement> icns;

    public List<IcnElement> getIcns() {
        return icns;
    }

    public void setIcns(List<IcnElement> icns) {
        this.icns = icns;
    }

}