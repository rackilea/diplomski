Session session = null;

    try {
       session = HibernateUtils.getSessionFactory().getCurrentSession();
       Transaction tx = session.beginTransaction();

       Order order = new Order();
       Item item = new Item();
       item.setQuantity(1);
       /* etc.. */
       order.addItem(item);
       item.setOrder(order);
       session.save(item);
       session.save(order);
       tx.commit();
    } finally {
       if (session.isOpen())
           session.close();
    }