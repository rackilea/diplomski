List result = session.createCriteria(Order.class)  
                        .setFetchMode("lineItems", FetchMode.JOIN)  
                        .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)  
                        .list();  


<class name="Order">  
    ...  
    <set name="lineItems" fetch="join">  

List result = session.createCriteria(Order.class)  
                        .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)  
                        .list();  

List result = session.createQuery("select o from Order o left join fetch o.lineItems")  
                      .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY) // Yes, really!  
                      .list();  

List result = session.createQuery("select distinct o from Order o left join fetch o.lineItems").list();