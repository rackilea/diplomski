package example;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactory {

    public static ObjectMapper getObjectMapper(final ObjectMapperProperties objectMapperProperties) {
        final ObjectMapper result = new ObjectMapper();
        result.setPropertyNamingStrategy(objectMapperProperties.getPropertyNamingStrategy());
        return result;
    }

}