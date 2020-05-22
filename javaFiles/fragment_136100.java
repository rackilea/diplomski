try {
   ....
} catch (PersistenceException e) {
  try { throw e.getCause(); }
  catch (SQLSyntaxException e) {
    // handle the exception
  }
}