@XmlRootElement(name = "IGE")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IGE", propOrder = { "altin" })
public class IGEType {


    @XmlElement(name = "Altin", required = true)
    public List<ALTINType> altin;

    public List<ALTINType> getALTIN() {
        if (altin == null) {
            altin = new ArrayList<ALTINType>();
        }
        return this.altin;
    }
}