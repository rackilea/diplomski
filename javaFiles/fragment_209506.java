public void insertPersonToDB()
    {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
            Person pers = new Person("param1","param2");
            short personID = (short) session.save(pers);
            tx.commit();
        }
        catch (HibernateException e)
        {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        finally
        {
            session.close();
        }
}