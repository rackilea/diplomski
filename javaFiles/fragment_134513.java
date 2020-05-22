NodeList nodes = doc.getElementsByTagName("employee");
     for (int i = 0; i < nodes.getLength(); i ++) {
         Node node = nodes.item(i);
         NamedNodeMap attr =  node.getAttributes();
         for(int j = 0 ; j<attr.getLength() ; j++) {
             Attr attribute = (Attr)attr.item(j);     
             System.out.println("Current Element :" + attribute.getName()+" = "+attribute.getValue());
          } 
     }