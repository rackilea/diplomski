RestTemplate restTemplate = new RestTemplate();
String isbn = "0132856204";
String endpoint = "https://openlibrary.org/api/books?jscmd=data&format=json&bibkeys=ISBN:{isbn}";

//Get JSON as String
String jsonString = restTemplate.getForObject(endpoint, String.class, isbn);

//Configure JsonPath to use Jackson for mapping
Configuration.setDefaults(new Configuration.Defaults() {
    private final JsonProvider jsonProvider = new JacksonJsonProvider();
    private final MappingProvider mappingProvider = new JacksonMappingProvider();

    @Override
    public JsonProvider jsonProvider() {
        return jsonProvider;
    }

    @Override
    public MappingProvider mappingProvider() {
        return mappingProvider;
    }

    @Override
    public Set<Option> options() {
        return EnumSet.noneOf(Option.class);
    }
});

//Parse the JSON as a book
Book book = JsonPath.parse(jsonString).read("$.ISBN:" + isbn, Book.class);