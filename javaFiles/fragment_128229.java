import java.io.File;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

abstract class AbstractClass
{
abstract NodeList getTagName( String tagName);
}
class ActualClass extends AbstractClass
{
DocumentBuilderFactory dbFactory;
DocumentBuilder dBuilder;
org.w3c.dom.Document doc;
String[] attribute;
public void document()
{
try
{
dbFactory = DocumentBuilderFactory.newInstance();
dBuilder = dbFactory.newDocumentBuilder();
doc = dBuilder.parse(new File("D:\\seachange\\AssetFlow Test Files\\VIDEOTRON_1.xml"));
doc.getDocumentElement().normalize();

}
catch (Exception e)
{
e.printStackTrace();
}
}
NodeList getTagName( String tagName )
{
NodeList mainNode = null;
if (doc != null)
{
mainNode=doc.getElementsByTagName(tagName);
}
return mainNode;
}
void readAttribute( NodeList mainNode, String attName)
{
if (doc != null)
{
attribute  = new String[mainNode.getLength()];
if (mainNode != null) {

for (int i = 0; i < mainNode.getLength(); i++) {
Node node = mainNode.item(i);
if (node.hasAttributes()) {

attribute[i] = node.getAttributes().getNamedItem(attName).getNodeValue();
}

}
}
}
}
void printOutput(NodeList mainNode, String attValue)
{
for (int i=0; i< mainNode.getLength(); i++)
{     

if ((attribute[i]).equals(attValue))
{
System.out.println(attribute[i]);

}

}
}
}


public class TestAbstract {

public static void main(String[] args) {
ActualClass A1= new ActualClass();
A1.document();
NodeList N1= A1.getTagName("Content");
A1.readAttribute(N1, "Value");
A1.printOutput(N1, "Movie_012.mpg");
}

}