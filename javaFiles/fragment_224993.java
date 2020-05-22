public class EnvironmentInformation implements Serializable, JsonSerializable {

    private final String[] profiles;

    public EnvironmentInformation(String[] environment) {
        this.profiles = environment;
    }

    public String[] getProfiles() {
        return profiles;
    }

    @Override
    public void serialize(JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();
        for (String fooValue : getProfiles()) {
            gen.writeString(fooValue);
        }
        gen.writeEndArray();
    }

    @Override
    public void serializeWithType(JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
        serialize(gen, serializers);
    }
}