@JsonDeserialize(using = DateDeserializer.class)
@JsonProperty("date")
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss z")




public class DateDeserializer extends StdDeserializer<Date> {

private static final SimpleDateFormat withSeconds = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss z");
private static final SimpleDateFormat withoutSeconds = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm z");

public DateDeserializer() {
    this(null);
}

public DateDeserializer(Class<?> vc) {
    super(vc);
}

@Override
public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    String dateString = p.getText();
    if (dateString.isEmpty()) {
        //handle empty strings however you want,
        //but I am setting the Date objects null
        return null;
    }

    try {
        return withSeconds.parse(dateString);
    } catch (ParseException e) {
        try {
            return withoutSeconds.parse(dateString);
        } catch (ParseException e1) {
            throw new RuntimeException("Unable to parse date", e1);
        }
    }
}
}