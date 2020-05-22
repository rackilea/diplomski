import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;

public class ReadData {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("someImage.jpg").toAbsolutePath();

        UserDefinedFileAttributeView fileAttributeView = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
        List<String> allAttrs = fileAttributeView.list();

        for (String att : allAttrs) {
            System.out.println("att = " + att);
        }
    }
}