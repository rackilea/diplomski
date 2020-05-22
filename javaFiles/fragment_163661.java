public void doVacuum(){
  org.hibernate.Session session = entityManager.unwrap(org.hibernate.Session);
  org.hibernate.internal.SessionImpl sessionImpl = (SessionImpl) session;  // required because Session doesn't provide connection()
  java.sql.Connection connection = sessionImpl.connection();
  connection.prepareStatement("VACUUM FULL").execute()
}