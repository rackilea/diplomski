Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();
    String hqlUpdate = "UPDATE TestTable SET lastRefreshDate = :dateToday";
    Query query = session.createQuery(hqlUpdate);
    query.setParameter("dateToday", new UtilityDate().getTodayDate());
    int result = query.executeUpdate();
    System.out.println("Rows affected: " + result);