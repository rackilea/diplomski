protected void doIt() {
  // for JDBC connection transaction may be started automatically
  // but assume we start it here
  Tran tran = session.beginTran();
  bool success = false;
  try {
    // here comes code that does some processing
    // modifies some data in transaction
    // etc.

    // success - so commit
    tran.commit();
    success = true;
  } finally { 
     // error - so rollback
     if (! success)
       tran.rollback();
  }      
}