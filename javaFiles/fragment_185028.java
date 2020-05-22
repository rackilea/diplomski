public void search(Document query, String databaseName, String collectionName, Continuation<List<Document>, Object> continuation) {
    Log.i(TAG, "Search query: " + query);
    _mongoClient.getDatabase(databaseName)  
         .getCollection(collectionName)
         .find(query)
         .continueWith(continuation);
}   //end method