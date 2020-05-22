public class Person {
    public String name;
    public int age;
    @JsonSerialize(using = IntToStringSerializer.class, as=String.class)
    public int favoriteNumber:
}


public class IntToStringSerializer extends JsonSerializer<Integer> {

    @Override
    public void serialize(Integer tmpInt, 
                          JsonGenerator jsonGenerator, 
                          SerializerProvider serializerProvider) 
                          throws IOException, JsonProcessingException {
        jsonGenerator.writeObject(tmpInt.toString());
    }
}