@Inject
RestApiProvider restApiProvider;

// Somewhere in your code
RestApiClassOfSomeSort instance = restApiProvider.getRestClient(RestApiClassOfSomeSort.class);
instance.// do what you need!