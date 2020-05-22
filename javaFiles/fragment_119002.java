public class JacksonSerializer {

public static class Contact {
    final public String email;
    final public String firstname;
    @JsonIgnore
    public String ignoreMe = "abc";

    public Contact(String email, String firstname) {
        this.email = email;
        this.firstname = firstname;
    }
}

public static class Property {
    final public String property;
    final public Object value;

    public Property(String property, Object value) {
        this.property = property;
        this.value = value;
    }
}

public static class Container {
    final public List<Property> properties;

    public Container(List<Property> properties) {
        this.properties = properties;
    }
}

public static void main(String[] args) throws JsonProcessingException {
    Contact contact = new Contact("abc@gmail.com", "John");
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.convertValue(contact, JsonNode.class);
    Iterator<String> fieldNames = node.fieldNames();
    List<Property> list = new ArrayList<>();
    while (fieldNames.hasNext()) {
        String fieldName = fieldNames.next();
        list.add(new Property(fieldName, node.get(fieldName)));
    }
    System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(new Container(list)));
}