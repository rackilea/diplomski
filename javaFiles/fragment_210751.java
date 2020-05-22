// load an ontology
OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
OWLOntology ontology = manager.loadOntologyFromOntologyDocument(ONTOLOGY_IRI);
OWLDataFactory df = manager.getOWLDataFactory();

// We need a reasoner to ask for individuals
OWLReasoner reasoner = createReasoner(ontology);
reasoner.precomputeInferences(InferenceType.CLASS_ASSERTIONS);

// get all the gaurdians in the ontology
OWLClass gaurdian = df.getOWLClass(IRI.create("#Gaurdian"));
Set<OWLNamedIndividual> gaurdians = reasoner.getInstances(gaurdian, false).getFlattened();


for (OWLNamedIndividual g : gaurdians) {
    // all wards of a given gaurdian g
    OWLObjectProperty isWardOf = df.getOWLObjectProperty(IRI.create("#isWardOf"));
    OWLClassExpression wardsOfG = df.getOWLObjectHasValue(isWardOf, g);
    // get all the wards related to a given gaurdian
    Set<OWLNamedIndividual> wards = reasoner.getInstances(wardsOfG, false).getFlattened();
    if ( wards.size() > 1 ) {
        // this set of wards is connected to the same gaurdian
    }
}