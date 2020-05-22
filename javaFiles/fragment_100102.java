OWLIndividual Item1 = df.getOWLNamedIndividual(IRI.create("http://test.com/test#Item1"));
    OWLObjectProperty Item1_Name = df.getOWLObjectProperty(IRI.create("http://test.com/test#Item"));
    OWLDataProperty Item1_Quantity = df.getOWLDataProperty(IRI.create("http://test.com/test#Quantity"));
    OWLIndividual Item1_List[] = { df.getOWLNamedIndividual(IRI.create("http://test.com/test#PencilBox")), df
        .getOWLNamedIndividual(IRI.create("http://test.com/test#Box")) };
    int Item1_QuntList[] = { 5, 4 };
    Set<OWLAxiom> axioms = new HashSet<OWLAxiom>();
    for (int i = 0; i < Item1_List.length; i++) {
        axioms.add(df.getOWLObjectPropertyAssertionAxiom(Item1_Name, Item1, Item1_List[i]));
        axioms.add(df.getOWLDataPropertyAssertionAxiom(Item1_Quantity, Item1_List[i], Item1_QuntList[i]));
    }