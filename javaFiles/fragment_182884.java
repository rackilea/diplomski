import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMarshaller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.util.List;

import static com.amazonaws.util.Throwables.failure;

public class MyCustomMarshaller implements DynamoDBMarshaller<List<MyObject>> {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final ObjectWriter writer = mapper.writer();

    @Override
    public String marshall(List<MyObject> obj) {

        try {
            return writer.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw failure(e,
                          "Unable to marshall the instance of " + obj.getClass()
                          + "into a string");
        }
    }

    @Override
    public List<MyObject> unmarshall(Class<List<MyObject>> clazz, String json) {
        final CollectionType
            type =
            mapper.getTypeFactory().constructCollectionType(List.class, MyObject.class);
        try {
            return mapper.readValue(json, type);
        } catch (Exception e) {
            throw failure(e, "Unable to unmarshall the string " + json
                             + "into " + clazz);
        }
    }
}