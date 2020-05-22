for(OWLClass owl_class : localOntology.getClassesInSignature(true)){
         for(OWLAnnotationAssertionAxiom annotations:owl_class.getAnnotationAssertionAxioms(localOntology))
             if(annotations.getProperty().getIRI().getFragment()==null) {
                            System.out.println("definition: "+annotations.getValue());
                                                                        }
                                                         }