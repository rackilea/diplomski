package parsers;

/**
 *
 * @author Arthur Kushman
 */
import javax.xml.stream.*;
import java.io.*;
import javax.xml.namespace.QName;

public class StAXTest {

  public static void main(String[] args) throws Exception {
  long time1 = System.currentTimeMillis();
    XMLInputFactory factory = XMLInputFactory.newInstance();
    // factory.setXMLReporter(myXMLReporter);
    XMLStreamReader reader = factory.createXMLStreamReader(
            new FileInputStream(
            new File("/Users/macpro/Desktop/myxml.xml")));

    /*String encoding = reader.getEncoding();

    System.out.println("Encoding: "+encoding);

    while (reader.hasNext()) {
      int event = reader.next();
      if (event == XMLStreamConstants.START_ELEMENT) {
        QName element = reader.getName();
        // String text = reader.getText();
        System.out.println("Element: "+element);
        // while (event != XMLStreamConstants.END_ELEMENT) {
          System.out.println("Text: "+reader.getLocalName());
        // }
      }
    }*/

  try {
    int inElement = 0;
    for (int event = reader.next();event != XMLStreamConstants.END_DOCUMENT;
    event = reader.next()) {
      switch (event) {
        case XMLStreamConstants.START_ELEMENT:
          if (isElement(reader.getLocalName(), "href")) {
            inElement++;
          }
          break;
        case XMLStreamConstants.END_ELEMENT:
          if (isElement(reader.getLocalName(), "href")) {
            inElement--;
            if (inElement == 0) System.out.println();
          }
          break;
        case XMLStreamConstants.CHARACTERS:
          if (inElement>0) System.out.println(reader.getText());
          break;
        case XMLStreamConstants.CDATA:
          if (inElement>0)  System.out.println(reader.getText());
          break;
      }
    }
    reader.close();
  } catch (XMLStreamException ex) {
    System.out.println(ex.getMessage());
    System.exit(1);
  }
    // System.out.println(System.currentTimeMillis());
    long time2 = System.currentTimeMillis() - time1;
    System.out.println(time2);
 }

  public static boolean isElement(String name, String element) {
    if (name.equals(element)) return true;
    return false;
  }

}