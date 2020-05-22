import java.io.*;
import java.util.*;
import org.json.*;

public class JsonSplit {

    private static final int BATCH_SIZE = 10;

    public static void flushFile(List<Object> objects, int d) throws Exception {
        try (FileOutputStream output = new FileOutputStream("split-" + d
            + ".json");
                Writer writer = new OutputStreamWriter(output, "UTF-8")) {
            JSONArray jsonArray = new JSONArray(objects);
            jsonArray.write(writer);
        }
    }

    public static void main(String[] args) throws Exception {
        int outputIndex = 0;
        try (InputStream input = new BufferedInputStream(
                new FileInputStream(args[0]))) {
            JSONTokener tokener = new JSONTokener(input);
            if (tokener.nextClean() != '[') {
                throw tokener.syntaxError("Expected start of JSON array");
            }
            List<Object> jsonObjects = new ArrayList<>();
            while (tokener.nextClean() != ']') {
                // Back up one character, it's part of the next value.
                tokener.back();
                // Read the next value in the array.
                jsonObjects.add(tokener.nextValue());
                // Flush if max objects per file has been reached.
                if (jsonObjects.size() == BATCH_SIZE) {
                    flushFile(jsonObjects, outputIndex);
                    jsonObjects.clear();
                    outputIndex++;
                }
                // Read and discard commas between array elements.
                if (tokener.nextClean() != ',') {
                    tokener.back();
                }
            }
            if (!jsonObjects.isEmpty()) {
                flushFile(jsonObjects, outputIndex);
            }
            // Verify that end of input is reached.
            if (tokener.nextClean() != 0) {
                throw tokener.syntaxError("Expected end of document");
            }
        }

    }

}