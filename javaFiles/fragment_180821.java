import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 

...

try {
    DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
    Document doc = docBuilder.parse (InputStreamYouBuiltEarlierFromAnHTTPRequest);
}
catch (ParserConfigurationException e)
{
    ...
}
catch (SAXException e)
{
    ...
}
catch (IOException e)
{
    ...
}

...