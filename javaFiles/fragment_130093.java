private EntityManagerFactory getEntityManagerFactory() {
    return Persistence.createEntityManagerFactory( getPersistenceUnitName(),
      getProperties() );
  }

  private Map getProperties() {
    Map result = new HashMap();

    // Read the properties from a file instead of hard-coding it here.
    // Or pass the password in from the command-line.
    result.put( "javax.persistence.jdbc.password", "PASSWORD" );

    return result;
  }