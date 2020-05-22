for(OWLClass owlClass: o.getClassesInSignature()){
// Get the annotations on the class that use the label property
for (OWLAnnotation annotation : owlClass.getAnnotations(o, dataFactoryf.getRDFSLabel())) {
    if (annotation.getValue() instanceof OWLLiteral) {
        OWLLiteral val = (OWLLiteral) annotation.getValue();
        if (val.getLiteral().equals(inputLabel)) {
            // at this point, the owlClass variable is the OWLClass you were looking for
            NodeSet<OWLClass> subClasses = this.reasoner.getSubClasses(owlClass, direct);
            return subClasses.getFlattened();
        }
    }
}
}