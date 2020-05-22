import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ParseJson {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        final String jsonStr = "{\"0\":[\"passFrom\",\"3/9/2018\",\"3/9/2018\",\"anotherMethod\",\"but\"],\"1\":[\"googleForAlongTIme\",\"3/9/2018\",\"3/9/2018\",\"stillCannotConvert\",\"theLinkHashMap\"]}";

        Map<Integer, List<String>> map = objectMapper.readValue(jsonStr, new TypeReference<LinkedHashMap<Integer, List<String>>>(){});

        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            System.out.printf("For item \"%d\", values are:\n", entry.getKey());
            for (String value : entry.getValue()) {
                System.out.printf("\t[%s]\n", value);
            }
        }
    }
}