public final class Q43113283 {

    private Q43113283() {
    }

    private static final String SUCCESS_JSON = "[{\"name\":\"John\",\"age\":21},{\"name\":\"Sarah\",\"age\":32}]";
    private static final String FAILURE_JSON = "{\"errors\":[{\"code\":1001,\"message\":\"Something blew up\"}]}";

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapterFactory(getApiResponseTypeAdapterFactory())
            .create();

    // Assuming that the Type instance is immutable under the hood so it might be cached
    private static final Type personsApiResponseType = new TypeToken<ApiResponse<List<Person>>>() {
    }.getType();

    @SuppressWarnings("unchecked")
    public static void main(final String... args) {
        final ApiResponse<Iterable<Person>> successfulResponse = gson.fromJson(SUCCESS_JSON, personsApiResponseType);
        final ApiResponse<Iterable<Person>> failedResponse = gson.fromJson(FAILURE_JSON, personsApiResponseType);
        useFullyCallbackApproach(successfulResponse, failedResponse);
        useSemiCallbackApproach(successfulResponse, failedResponse);
        useNoCallbackApproach(successfulResponse, failedResponse);
    }

    private static void useFullyCallbackApproach(final ApiResponse<Iterable<Person>>... responses) {
        System.out.println("<FULL CALLBACKS>");
        final IApiResponseConsumer<Iterable<Person>> handler = new IApiResponseConsumer<Iterable<Person>>() {
            @Override
            public void acceptSuccess(final Iterable<Person> people) {
                dumpPeople(people);
            }

            @Override
            public void acceptFailure(final List<ApiResponseError> errors) {
                dumpErrors(errors);
            }
        };
        Stream.of(responses)
                .forEach(response -> response.accept(handler));
    }

    private static void useSemiCallbackApproach(final ApiResponse<Iterable<Person>>... responses) {
        System.out.println("<SEMI CALLBACKS>");
        Stream.of(responses)
                .forEach(response -> {
                    final Iterable<Person> people = response.acceptOrNull(Q43113283::dumpErrors);
                    if ( people != null ) {
                        dumpPeople(people);
                    }
                });
    }

    private static void useNoCallbackApproach(final ApiResponse<Iterable<Person>>... responses) {
        System.out.println("<NO CALLBACKS>");
        Stream.of(responses)
                .forEach(response -> {
                    final Iterable<Person> people = response.acceptOrNull();
                    if ( people != null ) {
                        dumpPeople(people);
                    }
                });
    }

    private static void dumpPeople(final Iterable<Person> people) {
        for ( final Person person : people ) {
            System.out.println(person.name + " (" + person.age + ")");
        }
    }

    private static void dumpErrors(final Iterable<ApiResponseError> errors) {
        for ( final ApiResponseError error : errors ) {
            System.err.println("ERROR: " + error.code + " " + error.message);
        }
    }

}