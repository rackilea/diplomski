@XmlRootElement(name="HostStorageDomain")
public class HostStorageDomain
{
    @XmlElement
    public WWN[] WWN_list;

    @XmlAttribute(name="objectID")
    public String ObjectID;

    @XmlAttribute(name="portID")
    public String PortID;

    ...
}