static public Long WordCount(Observable<String> lineEmitter, String startTerm){
    return lineEmitter.flatMap(str -> Observable.fromArray(str.split("\\s")))
            .filter(str -> str.replaceAll("[^a-zA-Z0-9]", "").contains(startTerm))
            .count()
            .blockingGet();
}