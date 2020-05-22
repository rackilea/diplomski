package api.core.jasper;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;

public class UnitTest {

  @Test
  public void test() throws Exception {
    final ObjectMapper mapper = new XmlMapper();

    final XmlTest before =
        new XmlTest("0", Lists.newArrayList(new XmlTest("0.1", null),
            new XmlTest("0.2", Lists.newArrayList(new XmlTest("0.2.1", null)))));
    System.out.println(before);
    final String xml = mapper.writeValueAsString(before);
    System.out.println(xml);
    final XmlTest after = mapper.readValue(xml, XmlTest.class);
    System.out.println(after);
  }

  @JsonDeserialize(using = XmlTestDeserializer.class)
  @JacksonXmlRootElement(localName = "test")
  public static class XmlTest {
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    public String id;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "test")
    public List<XmlTest> children;

    public XmlTest(final String id, final List<XmlTest> children) {
      this.id = id;
      this.children = Optional.fromNullable(children).or(Lists.<XmlTest>newArrayList());
    }

    @Override
    public String toString() {
      return Objects.toStringHelper(this)
          .add("id", id)
          .add("children", children)
          .toString();
    }
  }

  public static class XmlTestDeserializer extends StdDeserializer<XmlTest> {

    protected XmlTestDeserializer() {
      super(XmlTest.class);
    }

    @Override
    public XmlTest deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException,
        JsonProcessingException {
      if (jp.getCurrentToken() != JsonToken.START_OBJECT) {
        throw new IOException("Invalid token, expected START_OBJECT");
      }

      String id = null;
      final List<XmlTest> children = Lists.newArrayList();

      while (jp.nextToken() != JsonToken.END_OBJECT) {
        final String key = jp.getCurrentName();
        jp.nextToken();

        if ("id".equals(key)) {
          id = jp.readValueAs(String.class);
        } else if ("test".equals(key)) {
          final XmlTest child = jp.readValueAs(XmlTest.class);
          if (child != null) {
            children.add(child);
          }
        }
      }

      jp.close();

      return new XmlTest(id, children);
    }
  }
}