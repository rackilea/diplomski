@JsonSerialize(using = CustomSerializer.class)
class Wheel {
   //getters and setters..
}


public class CustomSerializer extends JsonSerializer<Wheel> {

    @Override
    public void serialize(Wheel value, JsonGenerator generator, 
        SerializerProvider provider) throws IOException,
            JsonProcessingException {
                 if(value.getSomething() == something) {
                     //Output Wheel using the generator
                 } else {
                     //skip it
                 }
            }
}