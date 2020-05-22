import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;

class Test {
   public static void main(String [] args) throws Exception {
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       DocumentBuilder builder;
       builder = factory.newDocumentBuilder();
       StringReader sr = new StringReader("<foo />");
       InputSource is = new InputSource(sr);
       Document document = builder.parse(is);
       System.out.println(document.getDocumentElement().getTagName());
   }
}