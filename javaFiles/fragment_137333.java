import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class ParseStream {

  public static void main(String[] args) throws Exception {
    URLConnection connection =
      new URL("http://api.androidhive.info/pizza/?format=xml").openConnection();
    InputStream inputStream = connection.getInputStream();
    XMLStreamReader streamReader =
      XMLInputFactory.newInstance().createXMLStreamReader(inputStream, "UTF-8");
    while (streamReader.hasNext())
      if (streamReader.next() == XMLStreamConstants.START_ELEMENT)
        System.out.println("START_ELEMENT " + streamReader.getName());
  }
}