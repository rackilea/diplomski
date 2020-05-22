final IRI emptyOntologyIRI=...
OWLOntologyIRIMapper mapper = new OWLOntologyIRIMapper() {
    public IRI getDocumentIRI(IRI in) {
        return emptyOntologyIRI;
    }
};