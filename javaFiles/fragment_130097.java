public Observable<Document> getFirstDocument(String collectionName) {
    return Observable.create(emitter -> {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.find().first((document, throwable) -> {
            if(document != null) {
                emitter.onNext(document);
                emitter.onComplete();
            } else if(throwable != null) {
                emitter.onError(throwable);
            }
        });
    });
}