public void insertPersonToDB()
    {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            Person pers = new Person("param1","param2");
            short personID = (short) session.save(pers);
            tx.commit();
        }
        catch (HibernateException e){
              try {
                     if (tx != null) {
                       tx.rollback();                         
                       logger.error(e);
                      }
                  } catch(Exception e2) {
                     logger.error(e2);
                     throw new RunTimeException("rollback failed", e2);
                  }
             } 
        }
        finally{
            session.close();
        }
}