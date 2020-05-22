public class UserAccountAuthenticationSerializer extends JsonDeserializer<UserAccountAuthentication> {

@Override
public UserAccountAuthentication deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException {

    UserAccountAuthentication userAccountAuthentication = new UserAccountAuthentication();

    ObjectCodec oc = jsonParser.getCodec();
    JsonNode node = oc.readTree(jsonParser);
    userAccountAuthentication.setAuthenticated(node.get("authenticated").booleanValue());

    Iterator<JsonNode> elements = node.get("authorities").elements();
    while (elements.hasNext()) {
        JsonNode next = elements.next();
        JsonNode authority = next.get("authority");
        userAccountAuthentication.getAuthorities().add(new SimpleGrantedAuthority(authority.asText()));
    }
    return userAccountAuthentication;
}