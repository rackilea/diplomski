manager.addAxiom(
            ontology,factory.getOWLSubClassOfAxiom(
                    factory.getOWLClass("CCC", prefix ),
                    factory.getOWLObjectIntersectionOf(
                            new HashSet<T> (Arrays.asList(
                                    factory.getOWLObjectComplementOf(
                                            factory.getOWLClass("AAA", prefix )),
                                    factory.getOWLClass("AAA", prefix )) ))))  ;