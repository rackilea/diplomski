private User getUser(int id, String userType)
{
    User result;

    session = HibernateUtil.getWilsonsSessionFactory().getCurrentSession();
    session.beginTransaction();

    Query query = session.createQuery("select u from User u 
                                       where u.id = :id and u.role = :role");
    query.setParameter("id", id);
    query.setParameter("role", userType);

    result = (User)query.uniqueResult();

    session.getTransaction().commit();

    return result;  
}