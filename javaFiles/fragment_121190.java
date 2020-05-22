import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import static org.joox.JOOX.$;

public class Main {

    public static void main(String[] args) throws SAXException, IOException {
        $(new File(args[0]))
            .find("source")
            .forEach(elem -> System.out.println(elem.getTextContent().trim()));

    }
}