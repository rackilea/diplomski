import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "my name");
        map.put("b", "your name");

        filePatient(map, "c:\\temp\\test");
    }

    public static void filePatient(Map<String, String> collection, String filename) {
        // crating a file
        File file = new File(filename + ".txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(file), true)) {
            for (String name : collection.values()) {
                out.write(name);
            }
            out.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}