jcomeau@intrepid:/tmp$ cat so.xml ElementTest.java; java ElementTest
<?xml version="1.0" encoding="UTF-8"?>
<nodes totalCount="48" count="10">
<node type="A" id="83" label="label1">
<record>new</record>
<createTime>12345</createTime>
<node type="B">
</node>
</node>
<node type="A" id="77" label="label2">
<record>new</record>
<createTime>4567</createTime>
</node>
</nodes>
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.*;
public class ElementTest {
 public static void main(String args[]) throws Exception {
  InputStream reader = ElementTest.class.getResourceAsStream("so.xml");
  DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance(
   ).newDocumentBuilder();
  Document doc = dBuilder.parse(new InputSource(reader));
  doc.getDocumentElement().normalize();
  System.out.println("Dom Root element :" + doc.getDocumentElement().getNodeName());
  NodeList nList = doc.getElementsByTagName("node");
  for (int temp = 0; temp < nList.getLength();temp++) {
   Element element = (Element) nList.item(temp);
   NodeList time = element.getElementsByTagName("createTime");
   Element line = (Element) time.item(0);
   try {
    String value =getDataFromElement(line);  
    System.out.println("Create time: " + value );
   } catch (Exception problem) {
    System.err.println("problem element " + line + ": " + problem);
   }
  }
 }
 public static String getDataFromElement(Element e) {
  Node child = e.getFirstChild();
  if (child instanceof CharacterData) {
   CharacterData cd = (CharacterData) child;
   return cd.getData();
  }
  else return "";
 }
}
Dom Root element :nodes
Create time: 12345
problem element null: java.lang.NullPointerException
Create time: 4567