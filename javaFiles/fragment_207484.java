1. SessionFactory sessionFactory = null;
   2.   try {
   3.     sessionFactory = new Configuration().configure().buildSessionFactory();
   4.   } catch (Throwable ex) {
   5.     System.err.println("Initial SessionFactory creation failed. " + ex);
   6.     ex.printStackTrace();
   7.   }
   8.          
   9.   Session session = sessionFactory.getCurrentSession();
        // Here you are trying to access the Session which is not even created