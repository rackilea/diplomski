import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class CheckDupes {

    public static void main(String[] args) throws IOException {
        Set<String> lines = new HashSet<String>();
        Set<String> duplicateLines = new HashSet<String>();

        BufferedReader stdReader =
                new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        while (!(line = stdReader.readLine()).equals(":q")) {
            if (lines.contains(line)) {
                duplicateLines.add(line);
            } else {
                lines.add(line);
            }
        }

        duplicateLines.forEach(l -> System.out.println(l));
    }

}