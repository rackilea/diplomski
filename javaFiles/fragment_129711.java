File file=new File("ontology/pizza.owl");
    OWLOntologyManager manager;
    OWLOntology localOntology=null;
    OWLDataFactory factory ;

    try {


        //loading the ontology
        manager=OWLManager.createOWLOntologyManager();

        try {
            localOntology = manager.loadOntologyFromOntologyDocument(file);
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        }

        factory = localOntology.getOWLOntologyManager().getOWLDataFactory();

        OWLOntologyFormat format = manager.getOntologyFormat(localOntology);
        System.out.println("    format: " + format);

        ManchesterOWLSyntaxOntologyFormat manSyntaxFormat = new ManchesterOWLSyntaxOntologyFormat();
        if(format.isPrefixOWLOntologyFormat()) {
            manSyntaxFormat.copyPrefixesFrom(format.asPrefixOWLOntologyFormat());
        }

        manager.setOntologyFormat(localOntology, manSyntaxFormat);
        manager.saveOntology(localOntology, manSyntaxFormat);
        System.out.println("Manchester syntax: --- saved in Manchester.owl");

        ManchesterOWLSyntaxOWLObjectRendererImpl rendering = new ManchesterOWLSyntaxOWLObjectRendererImpl();

        OWLClass c1 = factory.getOWLClass(IRI.create("http://www.co-ode.org/ontologies/pizza/pizza.owl#IceCream"));

        Set<OWLClassExpression> c1eqclasses = c1.getEquivalentClasses(localOntology);
        for(OWLClassExpression c1e : c1eqclasses)
            System.out.println("Equivalent: "+rendering.render(c1e));

        c1eqclasses = c1.getDisjointClasses(localOntology);
        for(OWLClassExpression c1e : c1eqclasses)
            System.out.println("Disjoint: "+rendering.render(c1e));

        c1eqclasses = c1.getSubClasses(localOntology);
        for(OWLClassExpression c1e : c1eqclasses)
            System.out.println("Subclass: "+rendering.render(c1e));

        c1eqclasses = c1.getSuperClasses(localOntology);
        for(OWLClassExpression c1e : c1eqclasses)
            System.out.println("Superclass: "+rendering.render(c1e));



    }
    catch (OWLOntologyStorageException e) {
        System.out.println("Could not save ontology: " + e.getMessage());
    }



}