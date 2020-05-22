Observable
.from(originalDocumentNames)
.flatmap(key -> {
    //the stream of 0-1 original document
    Observable firstDocument = bucket.async().get(key);
    //the stream of 0-1 associated document
    Observable secondDocument = bucket.async().get(getSecondKeyNameFrom(key));

    //using zip and the createCustomObject method reference as a zip function to combine pairs of documents
    return Observable.zip(firstDocument, secondDocument, this::createCustomObject);
})
.toList() //let RxJava aggregate into a List
.subscribe(
    //the "callback" function, onNext will be called only once with toList
    list -> doSomething(list), 
    //always try to define onError (best practice)
    e -> processErrors(e)
);