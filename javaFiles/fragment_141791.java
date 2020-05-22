String urlString = "http://www.w3schools.com/xml/note.xml";
    URL url = new URL(urlString);
     DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(url.openStream());
    NodeList descNodes = doc.getElementsByTagName("note");

     for(int i=0; i<descNodes.getLength();i++)
     {
         System.out.println(descNodes.item(i).getTextContent());
     }