import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;

public class JacksonExample {

    static ObjectMapper mapper = new ObjectMapper();

    public static <T> ObjectReader createReader(Class<T> clazz, DeserializationConfig.Feature feature) {
        boolean enabled = mapper.getDeserializationConfig().isEnabled(feature);

        mapper.configure(feature, true);
        ObjectReader reader = mapper.reader(clazz);
        mapper.configure(feature, enabled);

        return reader;
    }

    public static <T> ObjectReader createReader(Class<T> clazz) {
        return mapper.reader(clazz);
    }

    public static void main(String[] args) throws Exception {

        // by default turn off this feature
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Should fail
        ObjectReader r1 = createReader(ExamplePojo.class, DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            ExamplePojo ex = r1.readValue("{\"a1\":1,\"b1\":\"Hello!\",\"c1\":1}");
            System.out.println(ex.getA1() + " " + ex.getB1());
        } catch (UnrecognizedPropertyException ex) {
            System.out.println(ex.getMessage());
        }

        // Should be ok
        ObjectReader r2 = createReader(ExamplePojo.class);
        try {
            ExamplePojo ex = r2.readValue("{\"a1\":2,\"b1\":\"Hello!\",\"c1\":2}");
            System.out.println(ex.getA1() + " " + ex.getB1());
        } catch (UnrecognizedPropertyException ex) {
            System.out.println(ex.getMessage());
        }

        // Should fail
        try {
            ExamplePojo ex = r1.readValue("{\"a1\":3,\"b1\":\"Hello!\",\"c1\":3}");
            System.out.println(ex.getA1() + " " + ex.getB1());
        } catch (UnrecognizedPropertyException ex) {
            System.out.println(ex.getMessage());
        }

        // Should be ok
        try {
            ExamplePojo ex = r2.readValue("{\"a1\":4,\"b1\":\"Hello!\",\"c1\":4}");
            System.out.println(ex.getA1() + " " + ex.getB1());
        } catch (UnrecognizedPropertyException ex) {
            System.out.println(ex.getMessage());
        }
    }
}