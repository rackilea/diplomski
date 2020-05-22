@XmlRootElement(name="ShoppingCart")
public class Cart1 {

    @XmlElement(name = "CurrentProducts")
    private List<Product1> productList = new ArrayList<>();
    @XmlAttribute(name="CartIdentifier")
    private long CartIdentifier;

    public Cart1() {}

    public Cart1(long id) {
        this.CartIdentifier=id;
    }
    // setters & getters
}