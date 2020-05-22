@XmlRootElement( name = "item" )
public class Item {

    @XmlElement( name = "item-url" )
    private String url;

    @XmlPath("parent/@id")
    private String parentId;
}