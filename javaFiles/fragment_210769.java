import java.io.*;
import javax.xml.*;
import javax.xml.parsers.*;
import javax.xml.validation.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class t {

  public static void main(String[] args) {
    try {
      DocumentBuilderFactory factory =
        DocumentBuilderFactory.newInstance();
      factory.setNamespaceAware(true);
      factory.setXIncludeAware(true);
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document itemDoc = builder.parse(new File("result.xml"));
      System.out.println(serialize(itemDoc));
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  static String serialize(Document doc) throws Exception {
    Transformer transformer =
      TransformerFactory.newInstance().newTransformer();
    StreamResult result = new StreamResult(new StringWriter());
    DOMSource source = new DOMSource(doc);
    transformer.transform(source, result);
    return result.getWriter().toString();
  }
}