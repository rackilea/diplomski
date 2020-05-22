public class MyDeserializer extends JsonDeserializer<Class<?>>  {

    // The default deserializer for a property of type Class
    private final FromStringDeserializer.Std defaultDeserializer;

    public MyDeserializer() {
        // Set the default deserializer
        this.defaultDeserializer = FromStringDeserializer.findDeserializer(Class.class);
    }

    public Class<?> deserialize(JsonParser jp, DeserializationContext ctxt) 
        throws IOException, JsonProcessingException {
        // Check whether we should used the custom or default deserializer
        // based on the bean class
        if (accept(jp.getCurrentValue().getClass())) {
            // The custom deserializer
            String token = jp.getText();
            switch(token) {
                case "FOO": return Foo.class;
                case "BAR": return Bar.class;
            }
            return null;
        }
        // Call the default deserializer
        return (Class<?>) defaultDeserializer.deserialize(jp, ctxt);
    }

    // Returns true if this bean class has fields of type Class that must
    // be deserialized with the custom deserializer, false otherwise
    public boolean accept(Class<?> beanClass) {
        // Implement your logic here
        // You could for example have all the bean classes in a Set and 
        // check that the provided class is in the Set 
    }
}