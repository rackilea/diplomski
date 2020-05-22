import java.io.IOException;
import java.io.InputStream;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class StationParser {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        InputStream ios = Library.class.getClassLoader().getResourceAsStream("data.json");
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode data = (ArrayNode) mapper.readTree(ios).get("myarray");
        Station[] stations = mapper.readValue(data.traverse(), Station[].class);

        for (Station station : stations) {
            System.out.println(station);
        }
    }
}