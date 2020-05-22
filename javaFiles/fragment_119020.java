public class CustomDateSerializer extends StdSerializer<Date> {

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public CustomDateSerializer() {
        this(null);
    }

    public CustomDateSerializer(Class t) {
        super(t);
    }

    @Override
    public void serialize(Date date, JsonGenerator generator, SerializerProvider provider) 
        throws IOException, JsonProcessingException {

        generator.writeString(formatter.format(date));
    }
}