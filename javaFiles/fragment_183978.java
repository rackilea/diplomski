import java.net.URL;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = dbf.newDocumentBuilder();

URL url = new URL("http://www.example.com/book.xml");
InputStream stream = url.openStream();
Document doc = docBuilder.parse(stream);