try {
    userType = (Type) session.load(Type.class, id);

    session.delete(userType);
/**
  * or JDBCException 
  * e.getCause()
  * e.getErrorCode() - vendor-specific
  */
} catch (HibernateException e) {
    // checkout Exception right here e.getCause();
}