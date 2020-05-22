public static String getRNO(){

    String valueRetrieved = null;

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = null;
    Document doc = null;

    try {
        db = dbf.newDocumentBuilder();
        doc = db.parse(new File("D:\\Loic_Workspace\\Test2\\res\\test.xml"));
        NodeList ndList = doc.getElementsByTagName("Students");
        String xmlRetrieved = ndList.item(0).getTextContent();

        if(xmlRetrieved != null) {
            //CALL OF STRING REPLACE METHOD TO PREVENT FROM
            //at com.sun.org.apache.xerces.internal.parsers.DOMParser.parse(Unknown Source)
            //at com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderImpl.parse(Unknown Source
            xmlRetrieved = xmlRetrieved.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");

            doc = db.parse(new InputSource(new StringReader(xmlRetrieved)));
            valueRetrieved = doc.getElementsByTagName("rno").item(0).getTextContent();
        }


    } catch (ParserConfigurationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SAXException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }


    return valueRetrieved;

}