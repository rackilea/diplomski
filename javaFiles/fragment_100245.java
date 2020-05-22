Property p1 = model.createProperty(...)
StmtIterator stmts = model.listStatements(null,p1,null); 
while ( stmts.hasNext() ) {
  Statement stmt = stmts.next();
  RDFNode subject = stmt.getSubject();
  if ( subject.isURIResource() ) {
    System.out.println( "Subject URI is: "+ subject.asResource().getURI() );
  }
}