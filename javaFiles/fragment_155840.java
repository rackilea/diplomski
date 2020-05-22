import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;


public class JAXPTransChain1 {


    public static void main(String[] args) throws FileNotFoundException, SAXException, ParserConfigurationException, TransformerException {
        String[] stylesheets = new String[] {"sheet1.xsl", "sheet2.xsl", "sheet3.xsl"};
        String inputDoc = "input1.xml";
        chainSheets(stylesheets, inputDoc, new StreamResult(System.out));
    }

    private static void chainSheets(String[] stylesheets, String inputDoc, Result result) throws FileNotFoundException, ParserConfigurationException, SAXException, TransformerConfigurationException, TransformerException {
        InputSource input = new InputSource(new FileInputStream(inputDoc));

        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        XMLReader reader = spf.newSAXParser().getXMLReader();

        SAXTransformerFactory stf = (SAXTransformerFactory)TransformerFactory.newInstance();

        XMLReader parent = reader;

        for (int i = 0; i < stylesheets.length; i++)
        {
            String sheetUri  = stylesheets[i];
            XMLFilter sheetFilter = stf.newXMLFilter(new StreamSource(new FileInputStream(sheetUri)));
            sheetFilter.setParent(parent);
            parent = sheetFilter;
        }

        Transformer proc = stf.newTransformer();

        SAXSource transSource = new SAXSource(parent, input);

        proc.transform(transSource, result);   

    }

}