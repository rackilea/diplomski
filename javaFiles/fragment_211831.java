NamedNodeMap map = ((Element) document.getDocumentElement()).getAttributes();
String namespace = map.getNamedItem("targetNamespace").getNodeValue();
String prefix = "";
for (int i = 0; i < map.getLength(); i++)
{
   Attr attr = (Attr) map.item(i);
   if (attr.getValue().equals(namespace) && !attr.getName().equals("targetNamespace"))
   {
      prefix = attr.getName().split(":")[1];
      break;
   }
}
System.out.println("ns: " + namespace);
System.out.println("pr: " + prefix);