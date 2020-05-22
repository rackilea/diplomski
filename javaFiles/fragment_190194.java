@XmlRootElement(name = "index-annotations")
public class OrderList {
   private Collection<Integer> orderIds;

   @XmlElement(name = "orderid", type = Integer.class)
   public Collection<Integer> getOrderId() {
       return orderIds;
   }
}


@XmlRootElement(name = "index-annotations")
public class OutputOrderList extends OrderList {
   @Override
   @XmlElement(name = "orderid", type = Integer.class)
   @XmlElementWrapper(name="orders")
   public Collection<Integer> getOrderId() {
       return orderIds;
   }
}