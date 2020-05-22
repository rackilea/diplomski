package example;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactoryImpl implements ObjectMapperFactory {

    public ObjectMapper getObjectMapper(final ObjectMapperProperties objectMapperProperties) {
        final ObjectMapper result = new ObjectMapper();
        result.setPropertyNamingStrategy(objectMapperProperties.getPropertyNamingStrategy());
        return result;
    }

}