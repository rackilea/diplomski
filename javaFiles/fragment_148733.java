package stackoverflow;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class JsonParser {

    private static final String urlString = "https://api.guildwars2.com/v1/world_names.json";
    public static void main(String[] args) throws IOException {
        JsonParser parser = new JsonParser();

        URL url = new URL(urlString);

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(url.openStream());
        List<DataTransferObject> dtoList = mapper.readValue(root, new TypeReference<List<DataTransferObject>>(){});

        for(DataTransferObject dto : dtoList) {
            System.out.println("DTO: " + dto);
        }
    }

    public static class DataTransferObject {
        public int id;
        public String name;

        @Override
        public String toString() {
            return "ID: " + id + " NAME: " + name;
        }
    }

}