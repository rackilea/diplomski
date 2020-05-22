protected boolean checkParam(String login, String sid) {
    Session session = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery
            ("Select u.login, u.sid from User u Where u.login = :login");
        query.setParameter("login",login);
        List listOfData = query.list();
        return listOfData.size() == 1 
               && listOfData.get(0).toString().equals(sidDb);
    } catch (HibernateException e) {
        // Do you really just want to print the stack trace to stdout?
        // I would probably change the method to allow the exception
        // to bubble up...
        e.printStackTrace();
    } finally {
        if (session != null) {
            session.close();
        }
    }
}