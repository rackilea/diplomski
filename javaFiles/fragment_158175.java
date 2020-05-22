/**
 * Converts an OWL API ontology into a JENA API model.
 * @param ontology the OWL API ontology
 * @return the JENA API model
 */
public static Model getModel(final OWLOntology ontology) {
    Model model = ModelFactory.createDefaultModel();

    try (PipedInputStream is = new PipedInputStream(); PipedOutputStream os = new PipedOutputStream(is)) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ontology.getOWLOntologyManager().saveOntology(ontology, new TurtleDocumentFormat(), os);
                    os.close();
                } catch (OWLOntologyStorageException | IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        model.read(is, null, "TURTLE");
        return model;
    } catch (Exception e) {
        throw new RuntimeException("Could not convert OWL API ontology to JENA API model.", e);
    }
}