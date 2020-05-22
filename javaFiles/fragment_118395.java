@JsonDeserialize(using = CustomerDeserializer.class)
public static class Customer{
  ....
}

public class CustomerDeserializer extends StdDeserializer<Customer> {

    public CustomerDeserializer() {
        super(Customer.class);
    }

    @Override
    public Customer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        Customer customer = new Customer();
        JsonNode treeNode = p.readValueAsTree();
        if (treeNode == null) {
            return null;
        }
        customer.setName(treeNode.get("name").asText());
        customer.setAge(treeNode.get("age").asInt());
        Address address = new Address();
        address.setStreet(treeNode.get("street").asText());
        address.setPostalcode(treeNode.get("postalcode").asText());
        customer.setAddress(address);
        return customer;
    }
}