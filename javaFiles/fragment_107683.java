public boolean exists(String value) {
    customerDao.openSessionWithTransaction();
    Query query = customerDao.openSession().createQuery("from Customers where email=? ");
    query.setString(0, value);
    if (query.uniqueResult()!= null) {
        return true;
    }
    return false;}