public class ItemDeserializer extends StdDeserializer<Item> { 
    // ... 

    @Override
    public Item deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {
        // Handle the different date formats here!

        return new Item(/*parsed date object*/);
    }
}