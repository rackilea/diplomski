@XmlAccessorType(XmlAccessType.FIELD) // add this to avoid FIELD/METHOD conflicts
public class Item {
    private int id;
    private String name;

    @XmlElement(name="item")//There is no need for XmlElementRef 
    private List<Item> items = new ArrayList<Item>();

    @XmlAttribute(name = "identifier", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String identifier;
    @XmlAttribute(name = "identifierref", required = false)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String identifierref;
    @XmlAttribute(name = "isvisible", required = false)
    protected boolean isvisible; 

    //I think here is accessors
    List[Items] getItems ...


}