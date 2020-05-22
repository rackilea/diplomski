/**
 * getter for orders
 * @return orders
 */
@XmlElement(name="order", type=OrderJaxbDao.class)
@XmlElementWrapper(name="orders")
public List<Order> getOrders() { return orders; };