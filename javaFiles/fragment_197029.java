public class BillDeserializer extends StdDeserializer<Bill> {

    public BillDeserializer() {
        this(null);
    }

    public BillDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Bill deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {

        JsonNode billNode = jp.getCodec().readTree(jp);
        Bill bill = new Bill();
        bill.setSiteId(billNode.get("bill").get("siteId").textValue());
        bill.setBillId(billNode.get("bill").get("billId").textValue());      
        return bill;
    }
}