ont.hasWife=model.createProperty("your namespace URI here","FAMhasWife");

StmtIterator iter = onto.model.listStatements(null,onto.hasWife,(RDFNode)null);  
    while (iter.hasNext()) {
        Statement stmt = iter.nextStatement();  

           System.out.print(stmt.getObject().toString());
  }