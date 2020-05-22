package training;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class TestFile {

    /**
     * @param args
     * @throws IOException
     */
    private static String field = "phpcookbook.pdf";
    private static String fileContent;

    public static void main(String[] args) throws IOException {
        boolean found = false;
        File file = new File("test.txt");
        List<String> lines = FileUtils.readLines(file);
        for (String line : lines) {
            if (line.equals(field)) {
                found = true;
                break;

            }
        }
        if (!found) {
            fileContent = FileUtils.readFileToString(file);
            fileContent += "\n" + field;
        }
        FileUtils.write(file, fileContent);
    }
}