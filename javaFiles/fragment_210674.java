final OWLOntologyManager m = OWLManager.createOWLOntologyManager();
    final OWLOntology o = m.createOntology();

    o.add(OWL.classAssertion(OWL.Individual("xxx:1"), OWL.Class("b:y")));
    o.add(OWL.classAssertion(OWL.Individual("xxx:2"), OWL.Class("b:y")));
    o.add(OWL.classAssertion(OWL.Individual("xxx:3"), OWL.Class("b:y")));
    o.individualsInSignature().forEach(System.out::println);

    final OWLEntityRenamer renamer = new OWLEntityRenamer(m, Collections.singleton(o));
    final Map<OWLEntity, IRI> entity2IRIMap = new HashMap<>();

    o.individualsInSignature().forEach(toRename ->
    {
        final IRI iri = toRename.getIRI();
        entity2IRIMap.put(toRename, IRI.create(iri.toString().replaceFirst("xxx", "yyy")));
    });

    o.applyChanges(renamer.changeIRI(entity2IRIMap));
    o.individualsInSignature().forEach(System.out::println);