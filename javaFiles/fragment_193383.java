public class JsonCustomerSerializer extends JsonSerializer<Customer>
{
    @Override
    public void serialize(Customer comp, JsonGenerator gen, SerializerProvider provider)throws IOException, JsonProcessingException
    {
        gen.writeStartObject();
        gen.writeObjectField("idCustomer", comp.idCustomer);
        gen.writeStringField("name", comp.infos.nameCompany);
        gen.writeEndObject();
    }
}