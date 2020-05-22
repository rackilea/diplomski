public RequestBuilder {
    // setters and getters for all properties

    public Request build() {
         doStuff();
         Request request = new Request(this);
         doAfterStuff();
         return request;
    }
}