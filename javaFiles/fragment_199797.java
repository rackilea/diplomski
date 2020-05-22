public List<Order> readOrders(Long customerId){
  Query query = em.createNamedQuery("select order from com.mycompany.Order where order.customer.id = :customerId and order.submitDate > :specificDate");
  // I use Joda time you can use java.util.Date directly
  DateTime specificDate= new DateTime().minusDays(15);

  query.setParameter("customerId", customerId);
  query.setParameter("specificDate", specificDate.toDate(),TemporalType.DATE);

 return query.getResultLis();
}