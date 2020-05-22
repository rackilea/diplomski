public String getDocuments(){
  ...
  CompletableFuture<String> result = new CompletableFuture<>(); // <-- create an empty, uncompleted Future

  collection.find(query).map(Document::toJson)
        .into(new HashSet<String>(), new SingleResultCallback<HashSet<String>>() {
            @Override
            public void onResult(HashSet<String> strings, Throwable throwable) {
              // here I have to get all the Json Documents in the set and
              // make a whole json string

              result.complete(wholeJsonString); // <--resolves the future
            }
        });

  return result.get(); // <-- blocks until result.complete is called
}