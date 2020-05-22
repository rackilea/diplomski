import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EntityTest {
    public static void main(String[] args) {
        String json = "[{\"id\": \"0\", \"ip\": \"123\", \"mac\": \"456\"}, {\"id\": \"1\", \"ip\": \"111\", \"mac\": \"222\"}]";

        for (SlaveEntity entity : jsonToSlaveEntity(json)) {
            System.out.println(entity);
        }
    }

    public static List<SlaveEntity> jsonToSlaveEntity(String json) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
           return objectMapper.readValue(
                   json,
                objectMapper.getTypeFactory().constructCollectionType(List.class, SlaveEntity.class)
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<SlaveEntity>();
    }
}