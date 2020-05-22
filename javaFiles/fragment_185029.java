// Do not define documents here 
search(query, database, collection, 
    new Continuation<List<Document>, Object>() {
        @Override
        public Object then(@NonNull final Task<List<Document>> task) throws Exception {
            if (!task.isSuccessful()) {
                Log.e(TAG, "Failed to execute query");
            } else {
                List<Document> documents = task.getResults();
                // process documents 
            } 
    });
// if you did define documents outside this, it'll still be empty