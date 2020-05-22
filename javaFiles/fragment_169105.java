public static void main2( String[] args ) {
    final String NS = "http://stackoverflow.com/q/20194409/1281433/";
    final OntModel model = ModelFactory.createOntologyModel( OntModelSpec.RDFS_MEM );
    OntProperty p = model.createOntProperty( NS+"PropertyName" );
    p.addDomain( model.getOntClass( NS+"ClassName" ));
    p.addRange( RDFS.Literal );
    model.write( System.out, "RDF/XML-ABBREV" );
}