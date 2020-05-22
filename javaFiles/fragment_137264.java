import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    public static void main(String[] args) {
        File from = new File("abc.txt"); 
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(from);
    System.out.println(jsonNode.get("policies").get(0).get("tasks").get(0).get("eligibility"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}