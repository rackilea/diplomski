public boolean saveStudent(Student student)
    {
    Session session=null;
    Transaction tx=null;
    SessionFactory sessionFactory = null;
        try 
    {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession(); 
        tx = session.beginTransaction(); 
        session.save(student);
        tx.commit();
        return true;
        }
        catch (Exception e) 
    {
         if(tx!=null && tx.isActive())
         {
          tx.rollback();//rolebacks the currect active transaction
         }
        return false;
        }
     finally 
    {
         if(session!=null && session.isOpen())
         {
           session.close();
         }
         if(tx!=null)
         {
           tx=null;
         }
        }
      }