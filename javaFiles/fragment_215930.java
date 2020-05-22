import java.io.*;
import javax.xml.stream.*;
import javax.xml.transform.*;
import javax.xml.transform.stax.*;
import javax.xml.transform.stream.*;

public class FormatBugUsingStaX {

    public static void main(String[] args) throws Exception {

        InputStream inputStream = new FileInputStream(args[0]);
        InputStreamReader in = new InputStreamReader(inputStream);
        XMLInputFactory factory = XMLInputFactory.newInstance();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        XMLStreamReader streamReader = factory.createXMLStreamReader(in);
        Writer out = new FileWriter(args[1]);
        t.transform(new StAXSource(streamReader), new StreamResult(out));
    }
}