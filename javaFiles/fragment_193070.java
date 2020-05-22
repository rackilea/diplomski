create(list);

// ------------------------

public static void create(List<Object> objList) throws DatabaseException {
  Session hsession = null;

  try {
    hsession = SqlDataHibernateUtil.getSessionFactory().openSession();
    Transaction htransaction = hsession.beginTransaction();

    int count = 0;
    for(Agagf x: objList) {
        hsession.save(obj);
        if ( ++count % 20 == 0 ) { //20, same as the JDBC batch size
            //flush a batch of inserts and release memory:
            hsession.flush();
            hsession.clear();
            count = 0;
        }
    }
  } catch (HibernateException ex) {
    throw new DatabaseException(ex);
  } finally {
    htransaction.commit();
    if (hsession != null) {
      hsession.close();
    }
  }
}