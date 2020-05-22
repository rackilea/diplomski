Connection myConn = . . .   // connection to the RDBMS for Database
  DatabaseMetaData dbmd = myConn.getMetaData();
  if (dbmd.supportsNamedParameters() == true)
  {
      System.out.println("NAMED PARAMETERS FOR CALLABLE"
                        + "STATEMENTS IS SUPPORTED");
  }