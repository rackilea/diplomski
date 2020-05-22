import javax.xml.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import java.io.*;

public class Proc
{
    public static void main(String[] args) throws Exception
    {
        //Parse the input document
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("in.xml"));

        //Set up the transformer to write the output string
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty("indent", "yes");
        StringWriter sw = new StringWriter();
        StreamResult result = new StreamResult(sw);

        //Find the first child node - this could be done with xpath as well
        NodeList nl = doc.getDocumentElement().getChildNodes();
        DOMSource source = null;
        for(int x = 0;x < nl.getLength();x++)
        {
            Node e = nl.item(x);
            if(e instanceof Element)
            {
                source = new DOMSource(e);
                break;
            }
        }

        //Do the transformation and output
        transformer.transform(source, result);
        System.out.println(sw.toString());
    }
}