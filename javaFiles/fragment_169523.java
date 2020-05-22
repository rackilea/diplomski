class   DemoVisitor implements ConnectionVisitor{
  public  int visit(Connection connection){
     System.out.println("Visiting Connection");
     return 1;
  }

  public int visit(SqlServerConnection sqlServerConnection){
     System.out.println("Visiting SqlServerConnection");
     return 1;
  }

  public  int visit(OracleConnection oracleConnection){
     System.out.println("Visiting Oracle Connection");
     return 1;
  }