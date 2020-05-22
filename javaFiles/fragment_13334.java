public static void loadModel(){
dataset.begin(ReadWrite.WRITE);
try{    
    Model namedModel1 = dataset.addNamedModel("NamedModel1");
    OntModel ontModel1 = ModelFactory.createOntologyModel();
    FileManager.get().readModel( ontModel1, "SourceOwl1.owl");
// Load second Model    
    Model namedModel1 = dataset.addNamedModel("NamedModel2");
    OntModel ontModel1 = ModelFactory.createOntologyModel();
    FileManager.get().readModel( ontModel, "SourceOwl2.owl");
// Similarly you can load many other models within same dataset.

    dataset.commit();
} catch (Exception e){
    System.out.println("Error in Loading model from source!!");
    e.printStackTrace();
} finally {

    dataset.end();
}