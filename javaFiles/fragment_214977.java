@JsonSerialize(using = IgnoreByTitleSerializer.class)
public class Book{ ... }

class IgnoreByTitleSerializer extends StdSerializer<Book> {
...
@Override
    public void serialize(
      Book book, JsonGenerator jgen, SerializerProvider provider) 
      throws IOException, JsonProcessingException {
        if(!book.getTitle().equals("IGNORE") {
            ...
        }
    }
}