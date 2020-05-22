NamedNodeMap attributes = node.getAttributes();
 if(attributes != null) {
       for(int j=0;j < attributes.getLength(); j++) {
           Node attribute = attributes.item(j);
           // do something with node and attribute
       }
 }