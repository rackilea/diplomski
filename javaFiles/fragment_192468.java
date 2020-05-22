import javax.xml.parsers.SAXParser; 
import javax.xml.parsers.SAXParserFactory; 
import org.xml.sax.XMLReader; 

public class Demo { 

    public static void main(String[] args) throws Exception { 
        SAXParserFactory spf = SAXParserFactory.newInstance(); 
        SAXParser sp = spf.newSAXParser(); 
        XMLReader xr = sp.getXMLReader(); 
        xr.setContentHandler(new MyContentHandler(xr)); 
        xr.parse("input.xml"); 
    } 
}