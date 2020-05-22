DatasetAccessor accessor = DatasetAccessorFactory.createHTTP("http://localhost:3030/ds/data");

// Download the updated model
Model updated = accessor.getModel();

// Save the updated model over the original file
updated.write(new FileOutputStream("example.owl"), "RDF/XML");