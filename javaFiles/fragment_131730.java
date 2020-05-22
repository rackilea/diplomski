@XmlRootElement(name = "icns")
public class IcnList {

    private List<IcnElement> icns;

    @XmlElement(required = true)
    public List<IcnElement> getIcns() {
        return icns;
    }

    public void setIcns(List<IcnElement> icns) {
        this.icns = icns;
    }

}