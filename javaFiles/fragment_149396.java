public class JSONLocalDateAdapter
extends JsonDeserializer<DateTime> {

private static final String DATE_FORMAT = "MM/dd/yyyy";
private DateTimeFormatter formatter = DateTimeFormat.forPattern( DATE_FORMAT );


/**
 * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
 */
@Override
public DateTime deserialize( JsonParser parser, DeserializationContext ctxt )
    throws IOException, JsonProcessingException {

    ObjectCodec oc = parser.getCodec();
    JsonNode node = oc.readTree( parser );
    String dateInStringFormat = node.asText();
    DateTime start = formatter.parseDateTime( dateInStringFormat );

    return start;
}