Model m = ModelFactory.createDefaultModel();
m.read("example.owl", "RDF/XML");

// Prepare your update...

// Create an UpdateExecution on the local model
UpdateProcessor processor = UpdateExecutionFactory.create(update, GraphStoreFactory.create(m));
processor.execute();

// Save the updated model 
updated.write(new FileOutputStream("example.owl"), "RDF/XML");