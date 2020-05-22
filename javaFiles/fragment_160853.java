import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;
import java.net.*;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

public class Movie {
    public static void main(String[] args) throws Exception {
        MovieResponse response;
        ObjectMapper mapper = new ObjectMapper();

        response = mapper.readValue(new File("C:\\M.json"), MovieResponse.class);
        System.out.println(response);
    }
}