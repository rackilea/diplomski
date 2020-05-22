class Executor<T> {

    private TypeToken<Response<T>> responseType;
    private Response<T> response;

    public Executor(TypeToken<Response<T>> responseType) {
        this.responseType = responseType;
    }

    public void execute() {
        this.response = new Gson().fromJson(json, responseType.getType());
    }

    public Response<T> getResponse() { return this.response; }

}

// client code:
Executor<Language> executor = new Executor<Language>(new TypeToken<Response<Language>>() { });
executor.execute();
List<Language> languages = executor.getResponse().getData();
System.out.println(languages.get(0).alias); // prints "be"