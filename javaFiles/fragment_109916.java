import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        double[][] array;
        try (FileInputStream in = new FileInputStream("test.json")) {
            array = mapper.readValue(in, double[][].class);
        }

        // Do something with array...
    }
}