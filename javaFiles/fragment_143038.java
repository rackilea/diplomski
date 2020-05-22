while ( it.hasNext() ) {
  OntClass klass = it.next();
  if ( klass.isURIResource() ) {       
    System.out.println( klass );
  }
}