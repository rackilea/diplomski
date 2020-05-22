import java.io.*;
import javax.xml.bind.JAXB;

public class Test {

  public static void main(String[] args) {
    String xmlString = "<ns1:dispatch xmlns:ns1=\"http://service.order.com\"><ns1:dispatchId>1</ns1:dispatchId><ns1:order><ns1:totalAmount>1000.0</ns1:totalAmount></ns1:order></ns1:dispatch>";

    Dispatch dispatch = (Dispatch) JAXB.unmarshal(
            new StringReader(xmlString), Dispatch.class);

    System.out.println(dispatch);
  }
}