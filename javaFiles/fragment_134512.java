NodeList nodes = doc.getElementsByTagName("employee");
     for (int i = 0; i < nodes.getLength(); i ++) {
         Node node = nodes.item(i);
         NamedNodeMap attr =  node.getAttributes();

         // find item using key name and then fetch the node value
         String id = attr.getNamedItem("id").getNodeValue();
         String pin = attr.getNamedItem("pin").getNodeValue();
         String name = attr.getNamedItem("name").getNodeValue();    
         System.out.println(id+" "+pin+" "+name);
     }