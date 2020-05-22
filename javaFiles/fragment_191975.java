public class tryNoBuiltin {

    public static void main(String[] args) throws OWLOntologyStorageException,
    OWLOntologyCreationException, IOException  {

        //Create a configuration model
        Resource configuration = ModelFactory.createDefaultModel().createResource();
        configuration.addProperty(ReasonerVocabulary.PROPruleMode, "hybrid");

        MyReasonerFactory MyReas = new MyReasonerFactory();
        GenericRuleReasoner reasonerRULE = (GenericRuleReasoner)MyReas.create(configuration);

        Model modelRULE= FileManager.get().loadModel("./prova_rules_M_rdf.owl");
        InfModel infModelRULE = ModelFactory.createInfModel(reasonerRULE, modelRULE);
        infModelRULE.prepare();

        //write down the result in RDFXML form
        infModelRULE.write(System.out);
    }

}