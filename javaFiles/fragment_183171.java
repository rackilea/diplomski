import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class BrokenTest
{
    private static final String NAMESPACE = "http://example.com";

    @JacksonXmlRootElement(localName="Outer", namespace = NAMESPACE)
    public static class Outer
    {
        @JacksonXmlProperty(localName="Foo", namespace = NAMESPACE)
        public final String foo;

        @JacksonXmlProperty(localName="Inner", namespace = NAMESPACE)
        @JacksonXmlElementWrapper(localName = "Inners", namespace = NAMESPACE)
        public final List<Inner> inners;

        @JsonCreator
        public Outer(
                @JacksonXmlProperty(localName="Foo", namespace = NAMESPACE) final String foo,
                @JacksonXmlProperty(localName="XXX", namespace = NAMESPACE) final List<Inner> inners)
        {
            this.foo = foo;
            this.inners = inners;
        }
    }

    @JacksonXmlRootElement(localName="Inner", namespace = NAMESPACE)
    public static class Inner
    {
        @JacksonXmlProperty(localName="Bar", namespace = NAMESPACE)
        public final String bar;

        @JacksonXmlProperty(localName="Baz", namespace = NAMESPACE)
        public final String baz;

        @JsonCreator
        public Inner(
                @JacksonXmlProperty(localName="Bar", namespace = NAMESPACE) final String bar,
                @JacksonXmlProperty(localName="Baz", namespace = NAMESPACE) final String baz)
        {
            this.bar = bar;
            this.baz = baz;
        }
    }

    @Test
    public void serializeInner() throws Exception
    {
        Inner inner = new Inner("inner bar", "inner baz");
        ObjectMapper mapper = new XmlMapper();
        String serialized = mapper.writeValueAsString(inner);
        assertEquals(serialized, "<Inner xmlns=\"http://example.com\"><Bar>inner bar</Bar><Baz>inner baz</Baz></Inner>");
    }

    @Test
    public void deserializeInner() throws Exception
    {
        String serialized = "<Inner xmlns=\"http://example.com\"><Bar>inner bar</Bar><Baz>inner baz</Baz></Inner>";
        ObjectMapper mapper = new XmlMapper();
        Inner inner = mapper.readValue(serialized, Inner.class);
        assertNotNull(inner);
        assertEquals("inner bar", inner.bar);
        assertEquals("inner baz", inner.baz);
    }

    @Test
    public void serializeOuter() throws Exception
    {
        Outer outer = new Outer("outer foo", Arrays.asList(new Inner("inner 1 bar", "inner 1 baz"), new Inner("inner 2 bar", "inner 2 baz")));
        ObjectMapper mapper = new XmlMapper();
        String serialized = mapper.writeValueAsString(outer);
        assertEquals(serialized, "<Outer xmlns=\"http://example.com\"><Foo>outer foo</Foo><Inners><Inner><Bar>inner 1 bar</Bar><Baz>inner 1 baz</Baz></Inner><Inner><Bar>inner 2 bar</Bar><Baz>inner 2 baz</Baz></Inner></Inners></Outer>");
    }

    @Test
    public void deserializeOuter() throws Exception
    {
        String serialized = "<Outer xmlns=\"http://example.com\"><Foo>outer foo</Foo><Inners><Inner><Bar>inner 1 bar</Bar><Baz>inner 1 baz</Baz></Inner><Inner><Bar>inner 2 bar</Bar><Baz>inner 2 baz</Baz></Inner></Inners></Outer>";
        ObjectMapper mapper = new XmlMapper();
        Outer outer = mapper.readValue(serialized, Outer.class); // fails
        assertNotNull(outer);
        assertEquals("outer foo", outer.foo);
        assertEquals(2, outer.inners.size());
        assertEquals("inner 1 bar", outer.inners.get(0).bar);
        assertEquals("inner 1 baz", outer.inners.get(0).baz);
        assertEquals("inner 2 bar", outer.inners.get(1).bar);
        assertEquals("inner 2 baz", outer.inners.get(1).baz);
    }
}