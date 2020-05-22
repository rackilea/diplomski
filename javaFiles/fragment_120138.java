import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.dom.DOMResult;
import org.w3c.dom.Document;
...
TransformerFactory mTransformFactory = TransformerFactory.newInstance();
cTransformer = mTransformFactory.newTransformer(new StreamSource(new StringReader(StringUtil.readFromResource("/foo.xslt"))));
Document mResultDoc = XmlUtil.createDocument();
Document mResultDoc = XmlUtil.parseXmlFile("foo.xml");
transformer.transform(new DOMSource(source), new DOMResult(mResultDoc));