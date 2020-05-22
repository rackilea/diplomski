Session session = sessionFactory.openSession();
Transaction tx = session.beginTransaction();
for  ( int i=0; i<888888; i++ ) {
  TableA record = new TableA();
    record.setXXXX();
    session.save(record)
    if ( i % 50 == 0 ) { //50, same as the JDBC batch size
        //flush a batch of inserts and release memory:
        session.flush();
        session.clear();
    }
}
tx.commit();
session.close();