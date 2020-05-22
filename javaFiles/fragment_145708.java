/**
 * getter for orders
 * @return orders
 */
@XmlElement(name="orders", type=OrderJaxbDao.class)
public List<Order> getOrders() { return orders; };