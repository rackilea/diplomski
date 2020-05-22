public class SOAPFaultSerializer extends StdSerializer<SOAPFault> {

    public SOAPFaultSerializer() {
        this(null);
    }

    public SOAPFaultSerializer(Class<SOAPFault> t) {
        super(t);
    }

    @Override
    public void serialize(SOAPFault fault, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        // serialize "interesting" SOAPFault information
        jgen.writeStringField("faultActor", fault.getFaultActor());
        jgen.writeStringField("faultCode", fault.getFaultCode());
        ...
        jgen.writeEndObject();
    }

    @Override
    public void serializeWithType(JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer) throws IOException, JsonGenerationException {
        typeSer.writeTypePrefixForObject(this, jgen, SOAPFault.class);
        serialize(value, jgen, provider);
        typeSer.writeTypeSuffixForObject(this, jgen);
    }
}

public class SOAPFaultDeserializer extends StdDeserializer<SOAPFault> { 

    public SOAPFaultDeserializer() { 
        this(null); 
    } 

    public SOAPFaultDeserializer(Class<?> vc) { 
         super(vc); 
    }

    @Override
    public SOAPFault deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
         JsonNode node = jp.getCodec().readTree(jp);
         // deserialize "interesting" SOAPFault information
         String faultActor = node.get("faultActor").asText();
         String faultCode = node.get("faultCode").asText();
         ...
         SOAPFactory factory = SOAPFactory.newInstance();
         SOAPFault fault = factory.createFault();
         // fill in SOAPFault with deserialized fields
         fault.setFaultActor(faultActor);
         fault.setFaultCode(faultCode);
         ...
         return fault;
    }
}