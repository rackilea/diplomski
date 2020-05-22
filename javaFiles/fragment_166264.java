public Customer getCustomer(Long customerIdFromCustomerListPage)
    throws Exception {

      Session session = HibernateUtil.getSessionFactory().openSession();
      Customer customer = (Customer )session.get(Customer.class, customerIdFromCustomerListPage); 
      return customer ;

}