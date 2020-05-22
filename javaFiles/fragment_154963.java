public class JsonTranslator {
    private static Gson gson = null;

    public void test(Book book1) {
        JsonElement je = gson.toJson(book1);  // convert book1 to json
        Book book2 = gson.fromJson(je, Book.class); // convert json to book2
        // book1 and book2 should be equivalent
    }

    public JsonTranslator() {

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Book.class, new BookTrnaslator());
        builder.registerTypeAdapter(Author.class, new AuthorTrnaslator());
        builder.setPrettyPrinting();
        gson = builder.create();
    }


    private class BookTrnaslator implements JsonDeserializer<Book>, JsonSerializer<Book> {
        public Card deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jobj = json.getAsJsonObject();
            Book book = new Book();
            book.setName(jobj.get("name").getAsString());
            book.setTags(jobj.get("tags").getAsJsonArray()); //Assuming setTags(JsonArray ja) exists
            book.setName(jobj.get("price").getAsInt());
            book.setAuthor(gson.fromJson(jobj.get("writer"), Author.class));
            return book;
        }

       public JsonElement serialize(Book src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject jobj = new JsonObject();
            jobj.addProperty("name", src.getName());
            jobj.add("tags", src.getTagsAsJsonArray());
            jobj.addProperty("price", src.getPrice());
            jobj.add("writer", gson.toJson(src.getAuthor()));
            return jobj;
       }
    }

    private class AuthorTrnaslator implements JsonDeserializer<Author>, JsonSerializer<Author> {
        public Card deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jobj = json.getAsJsonObject();
            Author author = new Author();
            author.setName(jobj.get("name").getAsString());
            return author;
        }

       public JsonElement serialize(Author src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject jobj = new JsonObject();
            jobj.addProperty("name", src.getName());
            return jobj;
       }
    }
}