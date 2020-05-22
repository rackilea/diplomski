File xmlFile = new File("C:\\Users\\Steven\\Workspace\\twitter\\src\\users.xml");
  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
  Document doc = dBuilder.parse(xmlFile);
  doc.getDocumentElement().normalize();
  NodeList nList = doc.getElementsByTagName("userId");//use the id tag name
  int maxId = 0;
  for(Node node: nList){
      if(Integer.parseInt(node.getTextContent()) > maxId ){
        maxId = Integer.parseInt(node.getTextContent());
      }
  }
  int newId = maxId +1; //use this ID
  xmlFile.close();//close the file