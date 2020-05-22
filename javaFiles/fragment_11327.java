import com.google.gson.Gson;
import java.io.FileReader;
import java.io.Reader;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new FileReader("NODES.txt")) {
            Gson gson = new Gson();
            Node[] features = gson.fromJson(reader, Node[].class);
             // work with features
        }
    }
}