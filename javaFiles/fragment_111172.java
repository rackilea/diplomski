@SuppressWarnings({"unchecked", "raw"})
public class JacksonEnumSet {
    public enum Type {
        YES, NO
    }
    public static class Bean {
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "type", isAttribute = true)
        @JsonSerialize(using = EnumSetSerializer.class)
        @JsonDeserialize(using = EnumSetDeserializer.class)
        private final EnumSet<Type> types;

        @JsonCreator
        public Bean(@JsonProperty("type") final EnumSet<Type> types) {this.types = types;}

        public EnumSet<Type> getTypes() {return types;}

        @Override
        public String toString() {
            return "Bean{" +
                    "types=" + types +
                    '}';
        }
    }

    public static class EnumSetSerializer extends JsonSerializer<EnumSet> {

        @Override
        public void serialize(
                final EnumSet value,
                final JsonGenerator gen,
                final SerializerProvider serializers)
                throws IOException {
            final StringBuilder builder = new StringBuilder();
            for (final Object e : value) {
                if (builder.length() > 0) {
                    builder.append(";");
                }
                builder.append(e);
            }
            gen.writeString(builder.toString());
        }
    }

    public static class EnumSetDeserializer extends JsonDeserializer<EnumSet>
        implements ContextualDeserializer {
        private Class enumType;

        @Override
        public EnumSet deserialize(
                final JsonParser p,
                final DeserializationContext ctxt) throws IOException {
            final String string = p.getValueAsString();
            final EnumSet enumSet = EnumSet.noneOf(enumType);
            for (final String name : string.split(";")) {
                enumSet.add(Enum.valueOf(enumType, name));
            }
            return enumSet;
        }

        @Override
        public JsonDeserializer<?> createContextual(
                final DeserializationContext ctxt, final BeanProperty property)
                throws JsonMappingException {
            final CollectionLikeType type = (CollectionLikeType)property.getType();
            final EnumSetDeserializer enumSetDeserializer = new EnumSetDeserializer();
            enumSetDeserializer.enumType = type.getContentType().getRawClass();
            return enumSetDeserializer;
        }
    }

    public static void main(String[] args) throws IOException {
        final XmlMapper mapper = new XmlMapper();
        final Bean bean = new Bean(EnumSet.allOf(Type.class));
        final String xml = mapper.writeValueAsString(bean);
        System.out.println(xml);
        System.out.println(mapper.readValue(xml, Bean.class));
    }

}