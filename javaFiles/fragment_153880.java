public long addTask(String name) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        TaskDAO dao = new TaskDAO(session);
        long id = dao.insert(name); 

        tx.commit();
        session.close()

        return id;
}

public void deleteTask(long id) throws DBException {
    try {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();            
        TaskDAO dao = new TaskDAO(session);
            dao.delete(id);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            throw new DBException(e);
        }
    }