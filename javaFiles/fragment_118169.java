public FindAction implements Callable<Document> {
   private final MongoDatabase database;
   private final collectionName;
   private final Document docToFind;
... 

 @Override
 public Document call() throws Exception {
   return database.getCollection(collectionName).find(docToFind);
 }