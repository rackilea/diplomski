private Future<String> loadFromDb() {
    Future<String> f = Future.future();
    //some internal loading from db
    String result = "fromDb";
    //when loading completes, pass it to future result
    f.complete(result);
    return f;
}