for (OWLClass c : myPizza.getClassesInSignature()) {
    if (c.getIRI().getFragment().equals("Person")){
        NodeSet<OWLNamedIndividual> instances = reasoner.getInstances(c, false);
        System.out.println(c.getIRI().getFragment());
        for (OWLNamedIndividual i : instances.getFlattened()) {
            System.out.println(i.getIRI().getFragment()); 
        }
    }
}