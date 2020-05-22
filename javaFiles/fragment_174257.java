public void applyAll() {
    final OWLClass clsA = factory.getOWLClass(iri(Motifs.class, "A"));

    final OWLDataPropertyExpression prop = factory.getOWLDataProperty(Utils.iri(Motifs.class, "prop"));
    //final OWLDataPropertyExpression equal = factory.getOWLDataProperty(IRI.create("http://www.w3.org/2003/11/swrlb#equal"));

    final SWRLVariable varX = factory.getSWRLVariable(iri(Motifs.class, "x"));
    final SWRLVariable varY = factory.getSWRLVariable(iri(Motifs.class, "y"));
    final OWLLiteral literal = factory.getOWLLiteral(50);
    final OWLNamedIndividual ind = declareIndividual(iri(Motifs.class, "me"));
    addAxiom(factory.getOWLDataPropertyAssertionAxiom(prop, ind, literal));

    final Set<SWRLAtom> antecedent = new HashSet<>();
    antecedent.add(factory.getSWRLDataPropertyAtom(prop, varX, varY));
    // antecedent.add(factory.getSWRLDataPropertyAtom(equal, varY, factory.getSWRLLiteralArgument(literal)));
    final List<SWRLDArgument> args = new ArrayList<>(2);
    args.add(varY);
    args.add(factory.getSWRLLiteralArgument(literal));
    antecedent.add(factory.getSWRLBuiltInAtom(IRI.create("http://www.w3.org/2003/11/swrlb#equal"), args));

    final Set<SWRLAtom> consequences = new HashSet<>();
    consequences.add(factory.getSWRLClassAtom(clsA, varX));

    addAxiom(factory.getSWRLRule(antecedent, consequences));

    final PelletReasoner pellet = PelletReasonerFactory.getInstance().createReasoner(ontology);
    final NodeSet<OWLClass> x = pellet.getTypes(ind, false);
    x.getNodes().forEach(node -> System.out.println(ind + " -> " + node.getRepresentativeElement()));

    System.out.println("------------------------------------");
    if (!pellet.isConsistent()) System.out.println("Ontology isn't consistent");
    final OWLObjectRenderer renderer = new DLSyntaxObjectRenderer();
    for (final OWLAxiom r : ontology.getAxioms())
        System.out.println(renderer.render(r));
}