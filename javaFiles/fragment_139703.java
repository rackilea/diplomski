import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Sorter {

    static Map<String, List<String>> read() throws FileNotFoundException,
            IOException {
        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
        String line;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        String value = "";
        while ((line = reader.readLine()) != null) {
            if (line.matches("\\s*")) {
                continue; // skip blank lines
            }
            // Assume line that begins with space is a course.
            if (Character.isSpaceChar(line.charAt(0))) {
                // Add new course to data if it's there.
                if (!map.containsKey(line)) {
                    map.put(line, new ArrayList<String>());
                }
                map.get(line).add(value);
            } else {
                // Add completed data to list if there is one.
                value = line;
            }
        }
        return map;
    }

    public static void main(String[] args) {
        try {
            Map<String, List<String>> list = read();
            Set<Entry<String, List<String>>> set = list.entrySet();
            for (Entry<String, List<String>> e : set) {
                System.out.println(e.getKey());
                for (String s : e.getValue()) {
                    System.out.println("\t" + s);
                }
            }
        } catch (Exception ex) {
            System.err.println("Read failed.");
        }
    }
}