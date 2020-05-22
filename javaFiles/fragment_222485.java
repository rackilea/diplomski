import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StackoverflowMain {

    public static void main(String[] args) {
        // create the values for a folder and the file name as Strings
        String folder = "Y:\\our\\destination\\folder";  // <-- CHANGE THIS ONE TO YOUR FOLDER
        String gitignore = ".gitignore";
        // create Paths from the Strings, the gitignorePath is the full path for the file
        Path folderPath = Paths.get(folder);
        Path gitignorPath = folderPath.resolve(gitignore);
        // create some content to be written to .gitignore
        List<String> lines = new ArrayList<>();
        lines.add("# folders to be ignored");
        lines.add("**/logs");
        lines.add("**/classpath");

        try {
            // write the file along with its content
            Files.write(gitignorPath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}