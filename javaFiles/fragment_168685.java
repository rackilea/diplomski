import java.io.ByteArrayInputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.junit.Test;

public class XMLOutTest{

@Test
public void textXML() {
    String input = "<?xml version=\"1.0\"?>" + "<root><subject>my subject</subject><bodytext>my body text</bodytext>my body table<bodytable></bodytable></root>";
    try {
        StreamSource src = new StreamSource(new ByteArrayInputStream(input.getBytes()));
        StreamSource xslSrc = new StreamSource(this.getClass().getResourceAsStream("/xmltransform.xsl"));
        StreamResult result = new StreamResult(System.out);

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer t = factory.newTransformer(xslSrc);
        t.transform(src, result);

    } catch (TransformerConfigurationException e) {
        e.printStackTrace();
    } catch (TransformerException e) {
        e.printStackTrace();
    }
}
}