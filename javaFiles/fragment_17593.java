public static void main(String[] args) {
    File fXmlSubFile = new File("Sub.xml");
    File fXmlOriginalFile = new File("Original.xml");
    File fDestFile = new File("myfile.xml");
    DocumentBuilderFactory dbFactory  = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder;
    FileChannel source = null;
    FileChannel destination = null;
    XPath xPath =  XPathFactory.newInstance().newXPath();

    try{
        if (!fDestFile.exists()) {
            fDestFile.createNewFile();
        }
        source = new FileInputStream(fXmlOriginalFile).getChannel();
        destination = new FileOutputStream(fDestFile).getChannel();
        if (destination != null && source != null) {
            destination.transferFrom(source, 0, source.size());
        }
        if (source != null) {
            source.close();
        }
        if (destination != null) {
            destination.close();
        }
        dBuilder = dbFactory.newDocumentBuilder();
        Document oSubDoc = dBuilder.parse(fXmlSubFile);
        Document oDestDoc = dBuilder.parse(fDestFile);
        oSubDoc.getDocumentElement().normalize();
        oDestDoc.getDocumentElement().normalize();

         String sDestExpression = "/DeploymentDescriptors/NameValuePairs";  
         String sSubExpression = "/NameValuePairs"; 
         NodeList nodeDestList = (NodeList) xPath.compile(sDestExpression).evaluate(oDestDoc, XPathConstants.NODESET);
         NodeList nodeSubList  = (NodeList) xPath.compile(sSubExpression).evaluate(oSubDoc, XPathConstants.NODESET);
         for (int i = nodeDestList.getLength()-1; i >=0 ; i--) {
            Node oDestNode = nodeDestList.item(i);
            if (oDestNode.getNodeType() == Node.ELEMENT_NODE) {
               Element oDestElement = (Element) oDestNode;
               for (int j =0; j<nodeSubList.getLength(); j++) {
                    Node oSubNode = nodeSubList.item(j);
                    if (oSubNode.getNodeType() == Node.ELEMENT_NODE) {
                       Element oSubElement = (Element) oSubNode;
                       if(oDestElement.getElementsByTagName("name").item(0).getTextContent().equals(oSubElement.getElementsByTagName("name").item(0).getTextContent())){
                        oDestNode.getParentNode().removeChild(oDestNode);
                       }
                    }
               }
            }
         }
         Source src = new DOMSource(oDestDoc);
         Result result = new StreamResult(fDestFile);
         Transformer transformer = null;
         transformer = TransformerFactory.newInstance().newTransformer();
         // Transform your XML document (i.e. save changes to file)
         transformer.transform(src, result);
    }catch(Exception ex){
        System.out.println("error:"+ex.getMessage());
        ex.printStackTrace();
    }
}