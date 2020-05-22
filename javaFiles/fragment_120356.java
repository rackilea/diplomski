@XmlRootElement(name= "list")
public class List {
  private List.Cart cart;

  @XmlElement(name= "cart")
  public List<Cart> getCart() {
    return this.cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }


@XmlRootElement(name= "cart")
public static class Cart {
   private List<Stuff> stuff;

   private List<Stuff> getStuff() {
     if (stuff == null) {
       stuff = new ArrayList();
     }
     return stuff;
  }
}

}