@XmlRootElement(name = "Cart")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cart {

    @XmlJavaTypeAdapter(EmptyTagAdapter.class)
    protected String tagName;
}