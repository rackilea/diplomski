import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ProfileApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();
        List<String> strings = Files.readAllLines(jsonFile.toPath());
        String json = String.join("", strings);

        JSONObject jsonObj = new JSONObject(json);

        NodeWalker nodeWalker = new NodeWalker(jsonObj);
        String[] files = {"info1.txt", "data1.txt", "data2.txt"};
        for (String file : files) {
            System.out.println(file + " contents -> " + nodeWalker.findContentFor(file));
        }
    }
}