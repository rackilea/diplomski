@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Root{

    @XmlElementWrapper(name="propertyList")
    @XmlElement(name="property")
    @JsonProperty("propertyList")
    private List<Property> propertyList;
}