public class ZonedDateTimeSerialzier extends JsonSerializer<ZonedDateTime>{
@Override
public void serialize(ZonedDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
    String parseDate = null;// parse here zoned date time
    gen.writeString(parseDate);
}
}