private Session getSession(SessionFactory sessionFactory){
 Session session = null;
 try{
     session = sessionFactory.getCurrentSession();
 }catch(HibernateException hex){
     hex.printStackTrace();
 }
 if(session == null && !session.isClosed()){
     session = sessionFactory.openSession();
 }
}