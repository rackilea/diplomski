//Get rdfs:comment
final OWLAnnotationProperty comment = factory.getRDFSComment();

//Create a walker
OWLOntologyWalker walker = 
                        new OWLOntologyWalker(Collections.singleton(ontology));

//Define what's going to visited
OWLOntologyWalkerVisitor<Object> visitor = 
                                new OWLOntologyWalkerVisitor<Object>(walker) {

  //In your case you visit the annotations made with rdfs:comment
  //over the object properties assertions
  @Override
  public Object visit(OWLObjectPropertyAssertionAxiom axiom) {
    //Print them
    System.out.println(axiom.getAnnotations(comment));
    return null;
  }
};

//Walks over the structure - triggers the walk
walker.walkStructure(visitor);