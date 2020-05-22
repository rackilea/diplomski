import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.io.File;
import java.util.Arrays;

public class XmlApp {

  public static void main(String[] args) throws Exception {
    File xmlFile = new File("./resources/test.xml");

    XmlMapper xmlMapper = new XmlMapper();
    xmlMapper.setDefaultUseWrapper(true);
    xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    Item[] itemInfo = xmlMapper.readValue(xmlFile, Item[].class);
    System.out.println(Arrays.toString(itemInfo));
  }
}

class Item {
  @JacksonXmlProperty(localName = "Element")
  private Element element;

  // getters, setters, toString
}

class Element {
  @JacksonXmlProperty(localName = "Link")
  private String link;

  // getters, setters, toString
}