List<String> obj = new ArrayList<String>();
      NodeList nList  = doc.getElementsByTagName("parent");
      for (int i = 0; i < nList.getLength(); ++i) {
          NamedNodeMap map = nList.item(i).getAttributes();
             for (int j = 0; j < map.getLength(); j++) {
                  Node attribute = map.item(j);
                  Node eNode = nList.item(i); // Use i value here that is the issue. 
                  Element name = (Element) eNode;
                  obj.add(new String("Value = "+attribute.getNodeValue() + ",Child=" + 
                      name.getElementsByTagName("child").item(0).getTextContent()));
             }
          }