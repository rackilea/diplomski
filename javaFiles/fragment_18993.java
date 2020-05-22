import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class JsonProgram {

    public static void main(String[] args) throws IOException {
        File json = new File("/x/data.json");
        JsonFactory jsonFactory = new JsonFactory();
        JsonParser parser = jsonFactory.createParser(json);
        // Skip all elements to first array
        while (parser.nextToken() != JsonToken.START_ARRAY) {
        }
        parser.nextToken();
        // First level
        while (parser.nextToken() != JsonToken.END_ARRAY) {
            // Skip inner start array element
            parser.nextToken();
            System.out.println();
            System.out.println("NEXT ARRAY NODE");

            BigDecimal first = parser.getDecimalValue();

            // Go to second value
            parser.nextToken();

            BigDecimal second = parser.getDecimalValue();

            // Skip inner end array element
            parser.nextToken();

            // Handle array item
            System.out.println("First: " + first.toString());
            System.out.println("Second: " + second.toString());
        }
    }
}