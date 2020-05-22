import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Main {
    public static void main(String[] args) throws IOException {
        String filename = args[0];
        File file = new File(filename);
        String content = FileUtils.readFileToString(file, "ISO8859_1");
        FileUtils.write(file, content, "UTF-8");
    }
}