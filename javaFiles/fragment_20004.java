Session session = factory.openSession();
Transaction tx = null;
try {
   tx = session.beginTransaction();       
   ...
   tx.commit();
}
catch (Exception e) {
   if (tx!=null) tx.rollback(); 
}finally {
   session.close();
}