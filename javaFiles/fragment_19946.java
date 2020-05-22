import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;

public class Test {
    public static void main(String[] args) throws Exception {
        File file = new File("test.xml");
        DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
                .parse(file);
    }
}