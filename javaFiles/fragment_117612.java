import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Proxy;

public class JacksonTest {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ExceptionLegacyObject exceptionLegacyObject = new ExceptionLegacyObject();
        ExtendedLegacyObject proxy = (ExtendedLegacyObject) Proxy.newProxyInstance(
                LegacyObject.class.getClassLoader(),
                new Class[] { ExtendedLegacyObject.class },
                new LegacyObjectHandler(exceptionLegacyObject)
        );
        System.out.println(mapper.writeValueAsString(proxy));
    }
}