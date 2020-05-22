import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        FileNode root = gson.fromJson(new FileReader(jsonFile), FileNode.class);
        String[] files = {"info1.txt", "data1.txt", "data2.txt"};
        for (String file : files) {
            System.out.println(file + " contents -> " + root.findContent(file));
        }
    }
}