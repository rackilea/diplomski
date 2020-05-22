import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.transform.stream.StreamSource;

import org.jdom.Element;
import org.jdom.output.DOMOutputter;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.Document;

public class Test {

  public static void main(String[] args) throws JAXBException {

    String fooString = "<foo bar=\"bar\"><baz><test value=\"something\" /></baz></foo>";
    JAXBContext jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
            .createContext(new Class<?>[] {Foo.class}, null);
    javax.xml.bind.Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    Foo foo = unmarshaller
            .unmarshal(new StreamSource(new ByteArrayInputStream(fooString.getBytes(StandardCharsets.UTF_8))), Foo.class)
            .getValue();

    System.out.println(foo);
  }

  @XmlRootElement
  private static final class Foo {

    @XmlAttribute
    public String bar;

    @XmlElement
    @XmlJavaTypeAdapter(ElementAdapter.class)
    public Element baz;

    @Override
    public String toString() {
        return "Foo [bar=" + bar + ", baz=" + jdomElementToString(baz) + "]";
    }

    private String jdomElementToString(Element element) {
        return new XMLOutputter(org.jdom.output.Format.getPrettyFormat()).outputString(element);
    }

  }

  private static final class ElementAdapter extends XmlAdapter<org.w3c.dom.Element, Element> {

    @Override
    public Element unmarshal(org.w3c.dom.Element valueToUnmarshal) throws Exception {
        org.jdom.input.DOMBuilder domBuilder = new org.jdom.input.DOMBuilder();
        org.jdom.Element jdomElement = domBuilder.build(valueToUnmarshal);
        return jdomElement;
    }

    @Override
    public org.w3c.dom.Element marshal(Element elementToMarshal) throws Exception {
        org.jdom.Document jdomDocument = new org.jdom.Document((Element) elementToMarshal.detach());
        DOMOutputter domOutputter = new DOMOutputter();
        Document domDocument = domOutputter.output(jdomDocument);
        return domDocument.getDocumentElement();
    }

  }
}