import org.apache.commons.io.FilenameUtils;

public class FilenameUtilTest {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.example.com/some/path/to/a/file.xml?foo=bar#test");

        System.out.println(FilenameUtils.getBaseName(url.getPath())); // -> file
        System.out.println(FilenameUtils.getExtension(url.getPath())); // -> xml
        System.out.println(FilenameUtils.getName(url.getPath())); // -> file.xml
    }

}