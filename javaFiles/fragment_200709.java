import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        String jsonString = loadJSONFile();

        JsonElement jsonElement = new JsonParser().parse(jsonString);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        print(jsonObject);
    }

    private static String loadJSONFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("path/to/the/json/file.ext"));
        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNext()) {
            stringBuilder.append(scanner.next());
        }

        scanner.close();

        return stringBuilder.toString();
    }

    private static void print(JsonObject jsonObject) {
        Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();

        for (Map.Entry<String, JsonElement> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

            try {
                JsonElement jsonElement = new JsonParser().parse(String.valueOf(entry.getValue()));
                JsonObject innerJsonObject = jsonElement.getAsJsonObject();

                print(innerJsonObject);
            } catch (Exception e) {
                // is not a JSON
            }
        }
    }
}