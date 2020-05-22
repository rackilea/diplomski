List result = session.createCriteria(Order.class)  
                        .setFetchMode("lineItems", FetchMode.JOIN)  
                        .list();

<class name="Order">           
    <set name="lineItems" fetch="join">
    ...
</class>

List result = session.createCriteria(Order.class)  
                        .list();