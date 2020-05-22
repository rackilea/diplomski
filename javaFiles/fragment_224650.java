@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MyXmlMappings  {
    @XmlElement(name="xmlMapping")
    protected List<XmlMapping> xmlMappings;

}