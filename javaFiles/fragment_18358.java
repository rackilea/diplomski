package example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import example.ObjectMapperProperties.ObjectMapperPropertiesBuilder;

public class Client {

    public static void main(String[] args) {
        ObjectMapperPropertiesBuilder objectMapperPropertiesBuilder = new ObjectMapperPropertiesBuilder();
        objectMapperPropertiesBuilder.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        ObjectMapperFactory factory = new ObjectMapperFactory();
        ObjectMapper objectMapper = ObjectMapperFactory.getObjectMapper(objectMapperPropertiesBuilder.build());

    }

}