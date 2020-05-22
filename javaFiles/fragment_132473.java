Query q= this.sessionFactory.getCurrentSession()
   .createQuery("delete  SDPLines where value=:valore and SessionId=:id");
  q.setString("valore",  fingerprint);
  q.setString("id",sessionid);

  q.executeUpdate();

  session.getTransaction().commit();
}catch(Exception e){
    session.getTransaction.rollback();
}finally{
    session.close();
}