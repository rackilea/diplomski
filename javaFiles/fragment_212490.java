import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public void readCDATAFromXMLUsingStax() {
    String yourSampleFile = "/path/toYour/sample/file.xml";
    XMLStreamReader r = null;
    try (InputStream in =
            new BufferedInputStream(new FileInputStream(yourSampleFile));) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        r = factory.createXMLStreamReader(in);
        while (r.hasNext()) {
            switch (r.getEventType()) {
            case XMLStreamConstants.CHARACTERS:
            case XMLStreamConstants.CDATA:
                System.out.println(r.getText());
                break;
            default:
                break;
            }
            r.next();
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    } finally {
        if (r != null) {
            try {
                r.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}