@Override
public List<Member> findAll()
{
    Session session;
    try {
     session = sessionFactory.getCurrentSession();
    } catch (HibernateException e) {
     session = sessionFactory.openSession();
    }

   return session.createQuery("SELECT m FROM Member m", Member.class).getResultList();
}