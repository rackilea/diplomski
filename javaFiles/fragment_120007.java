public class CustomDateSerializer extends StdSerializer<Date> {

    private SimpleDateFormat formatter
            = new SimpleDateFormat("dd-MM-yyyy");
    private SimpleDateFormat formatter1
            = new SimpleDateFormat("dd-MM");

    public CustomDateSerializer() {
        this(null);
    }

    public CustomDateSerializer(Class t) {
        super(t);
    }

    @Override
    public void serialize (Date value, JsonGenerator gen, SerializerProvider arg2)
            throws IOException, JsonProcessingException {
        Date date;
        try {
            //if not valid, it will throw ParseException
            date = formatter.parse(value.toString());
        } catch (ParseException e) {
            try {
                date = formatter1.parse(value.toString());
            }catch(ParseException ex) {
                ex.printStackTrace();                    
            }
        }
        gen.writeString(formatter.format(date));
    }
}