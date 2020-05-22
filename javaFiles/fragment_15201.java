class ResponseWrapper<T> {
    public final Long generationTime;
    public final T response;

    public ResponseWrapper(final Long generationTime, final T response) {
        this.generationTime = generationTime;
        this.response = response;
    }
}

@...
public ResponseWrapper<HelloWorld> helloWorld(...) {
    long startTime = System.currentTimeMillis();

    // process the request

    long elapsedTime = System.currentTimeMillis() - startTime;

    return new ResponseWrapper<HelloWorld>(elapsedTime , new HelloWorld(...));
}