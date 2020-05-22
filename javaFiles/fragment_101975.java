import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

// ...

String foAsString = "your_fo_as_string";
File destination = new File("path_to_file"");

OutputStream outStream = new BufferedOutputStream(new FileOutputStream(destination));
Fop fop = fopFactory.newFop(MimeConstants.MIME_POSTSCRIPT, outStream);

Transformer transformer = transformerFactory.newTransformer();
Source source = new StreamSource(new StringReader(foAsString));
Result result = new SAXResult(fop.getDefaultHandler());

transformer.transform(source, result);

outStream.close();

return destination;