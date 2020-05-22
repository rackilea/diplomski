import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;

TransformerFactory factory = TransformerFactory.newInstance();

Templates xslTemplate = factory.newTemplates(new StreamSource(new StringReader(xsl)));