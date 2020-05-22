@XmlRootElement(name = "CashRegister")
public class Register1 {

    @XmlElement(name = "ShoppingCart")
    private ArrayList<Cart1> listCart;

    long CartIdentifier;

    public Register1() {

    }

    public Register1(long id) {
        this.CartIdentifier=id;
    }
    //setters & getters
}