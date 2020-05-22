@XmlRootElement( name = "item" )
public class Item {

    @XmlElement( name = "item-url" )
    private String url;

    @XmlElement( name = "parent" )
    @XmlJavaTypeAdapter(ParentIdAdapter.class)
    private String parentId;
}