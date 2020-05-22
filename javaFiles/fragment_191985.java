ObjectMapper mapper = new ObjectMapper();
mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

JsonNode root = mapper.readTree(json); // read as JsonNode 
JsonNode items = root.at("/items");
List<Book> books = new ArrayList<>();
if (items.isArray()) {
    ArrayNode array = (ArrayNode) items;
    array.forEach(n -> {
        Book book = mapper.convertValue(n.get("volumeInfo"), Book.class); // convert to Book
        books.add(book);
    });
}
System.out.println(books);