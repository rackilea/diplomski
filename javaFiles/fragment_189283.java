@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "webCheckType", propOrder = {
    "number"
})
public class WebCheckType {

    @XmlElementRefs({
        @XmlElementRef(name = "beginAt", type = JAXBElement.class),
        @XmlElementRef(name = "gotoPage", type = JAXBElement.class),
        @XmlElementRef(name = "baseUrl", type = JAXBElement.class)
    })
    protected List<JAXBElement<Object>> number;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "extends")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object _extends;
    @XmlAttribute(required = true)
    protected String displayName;

........................
.......................

public List<JAXBElement<Object>> getNumber() {
        if (number == null) {
            number = new ArrayList<JAXBElement<Object>>();
        }
        return this.number;
    }