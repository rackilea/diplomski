for (OWLClass cls : ontology.getClassesInSignature()) {
    for (OWLAnnotationAssertionAxiom annAx : EntitySearcher.getAnnotationAssertionAxioms(cls.getIRI(), ontology)) {
        if (annAx.getValue().getValue() instanceof OWLLiteral) {
            m.removeAxiom(annAx);
        }
    }
}