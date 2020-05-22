//OWL Expression we would like to create:
//in OWL Functional syntax: ObjectIntersectionOf(A ObjectSomeValuesFrom(R B))
//in Manchester syntax: A and R some B
PrefixManager pm = new DefaultPrefixManager("http://example.org/");
OWLClass A = factory.getOWLClass(":A", pm);
OWLObjectProperty R = factory.getOWLObjectProperty(":R", pm);
OWLClass B = factory.getOWLClass(":B", pm);

//The expression
OWLClassExpression expression = 
  factory.getOWLObjectIntersectionOf(A, factory.getOWLObjectSomeValuesFrom(R, B));

//Create a class in order to use the expression
OWLClass C = factory.getOWLClass(":C", pm);

// Declare an equivalentClass axiom
//Just there to show how an example on how to use the expression
OWLAxiom definition = factory.getOWLEquivalentClassesAxiom(C, expression);
manager.addAxiom(ontology, definition);