import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.junit.Test;


public class JAXBTest {

    @Test
    public void test() throws javax.xml.bind.JAXBException {
        String xml = 
            "<foo>" +
            "  <bar>" +
            "    <baz>qux</baz>" +
            "  </bar>" +
            "</foo>";

        javax.xml.bind.JAXBContext context = javax.xml.bind.JAXBContext.newInstance(
                FooImpl.class,
                BarImpl.class
        );

        javax.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();

        unmarshaller.unmarshal(new java.io.StringReader(xml));
    }

    @XmlTransient
    public static abstract class Foo {
        @XmlElements({
            @XmlElement(name="bar",type=BarImpl.class),
            @XmlElement(name="bar",type=BarImpl2.class),
        })
        Bar bar;
    }

    @XmlTransient
    public static abstract class Bar {
        @XmlElement(name="baz")
        String baz;
    }

    @XmlRootElement(name="foo")
    public static class FooImpl extends Foo { }

    @XmlRootElement(name="bar")
    public static class BarImpl extends Bar { }

    public static class BarImpl2 extends Bar { }
}