public class Parent implements JsonSerializable {

        String parentField;

        @Override
        public void serialize(JsonGenerator gen, SerializerProvider serializers) throws IOException {

            startSerialize(gen);
            doSerialize(gen, serializers);
            endSerialize(gen);
        }

        @Override
        public void serializeWithType(JsonGenerator gen, SerializerProvider serializers, TypeSerializer typeSer) throws IOException {
        }

        protected void startSerialize(JsonGenerator gen) throws IOException {
            gen.writeStartObject();
        }

        protected void doSerialize(JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStringField("parentField", parentField);
        }

        protected void endSerialize(JsonGenerator gen) throws IOException {
            gen.writeEndObject(); // Closing Object..
        }
    }

    public class Sub extends Parent {

        String subField;

        @Override
        protected void doSerialize(JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStringField("subField", subField);
        }
    }
}