final CriteriaBuilder builder = getSessionFactory().getCurrentSession().getCriteriaBuilder();
         CriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);
         Root<Customer> Customer = criteriaQuery.from(Customer.class);     
         criteriaQuery.where(builder.equal(builder.upper(customer.get("customerName")),customerName.toUpperCase()));
         Query<Customer> query = getSessionFactory().getCurrentSession().createQuery(criteriaQuery);
         final List<Customer> results = query.getResultList();