import java.io.*;
import java.util.*;
import org.json.*;

public class JsonSplitNaive {

    /*
     * Naive version - do not use, will fail with OutOfMemoryError for
     * huge inputs.
     */

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
            List<Object> jsonObjects = new ArrayList<>();
            JSONArray jsonArray = new JSONArray(new JSONTokener(input));
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObjects.add(jsonArray.get(i));
                // Flush if max objects per file has been reached.
                if (jsonObjects.size() == BATCH_SIZE) {
                    flushFile(jsonObjects, outputIndex);
                    jsonObjects.clear();
                    outputIndex++;
                }
            }
            if (!jsonObjects.isEmpty()) {
                flushFile(jsonObjects, outputIndex);
            }
        }
    }

}