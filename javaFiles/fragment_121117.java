public void doWork(){
  Transaction tx = null;
   try{
     tx = session.beginTransaction();  
   }catch(){
   } finally {
     // if tx != null then.. close transaction, or rollback?
   }
}