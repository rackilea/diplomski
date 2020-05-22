import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import java.io.*;

public class Test {

    public static void main(String[] args)
            throws FileNotFoundException {

        //JSON Array [ROOT]
        JsonObject finalOutput = new JsonObject();

        //Libraries Array
        JsonArray libraries = new JsonArray();
        for (int i = 0; i < 2; i++) {
            JsonObject object = new JsonObject();
            object.put("name", "library->" + i);
            libraries.add(object);
        }

        finalOutput.put("libraries", libraries);

        //Write to File
        try (FileWriter file = new FileWriter("C:\\Users\\b21677\\output.json")) {
            file.write(finalOutput.toJson());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}