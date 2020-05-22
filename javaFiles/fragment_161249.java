public List<T> getAll( Class theClass) {
    List<T> entity = null;
    Transaction trns = null;
    Session session = sessionFactory.openSession();
    try {         
        trns = session.beginTransaction();
        Criteria criteria = session.createCriteria(theClass);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
        entity = criteria.list();
        session.getTransaction().commit();
    } catch (RuntimeException e) {
        e.printStackTrace();
    }finally {
    session.flush();
    session.close();
 }
    return entity;
 }