NodeList list = doc.getElementsByTagName("photo");
element = (Element)list.item(0);
list = element.getChildNodes();

int ix = 0;
while (ix < list.getLength() && list.item(ix).getNodeType() != Node.ELEMENT_NODE) {
  ix++;
}

// now ix points to your first element node (if there was one)

System.out.println(list.item(ix).getNodeName());
System.out.println(list.item(ix).getNodeValue());