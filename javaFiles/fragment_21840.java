class Foo {
    private String msg;

    // Constructor, setters, getters
}

class Holder {
    private List<Foo> foo;
    private Foo other;

    // Constructors, setters, getters
}

public class FooTest {

    @org.junit.Test
    public void testCollectionFromJSONValue() throws Exception {
        final InputStream stream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream("foo.json");

        final String json = IOUtils.toString(stream);

        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(
                DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
                true);
        final Holder holder = mapper.readValue(json, Holder.class);
        System.out.println(holder);
    }
}