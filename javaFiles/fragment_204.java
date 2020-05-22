OWLObjectProperty teacherP= factory.getOWLObjectProperty(IRI
            .create(ontologyIRI + "#teacherOf"));

    SWRLVariable var1 = factory.getSWRLVariable(IRI.create(ontologyIRI
            + "#y"));
    SWRLVariable var2 = factory.getSWRLVariable(IRI.create(ontologyIRI
            + "#x"));
    SWRLObjectPropertyAtom teacherAtom = factory.getSWRLObjectPropertyAtom(
            teacherP, var1, var2);
    Set<SWRLAtom> SWRLatomList= new HashSet<SWRLAtom>();
    SWRLatomList.add(teacherAtom);