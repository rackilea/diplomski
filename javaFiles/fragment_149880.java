public class CustomSerializer extends JsonSerializer<MyClass> {


    @Override
    public void serialize(MyClass myClass, JsonGenerator generator,
                          SerializerProvider provider) throws IOException {

        String dateString = String.valueOf(myClass.getDateTime().getMillis());
        generator.writeString(dateString);
    }
}