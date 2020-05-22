public class XMLfunctions {

public final static Document XMLfromString(String xml){

    Document doc = null;

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    try {

        DocumentBuilder db = dbf.newDocumentBuilder();

        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xml));
        doc = db.parse(is); 

    } catch (ParserConfigurationException e) {
        System.out.println("XML parse error: " + e.getMessage());
        return null;
    } catch (SAXException e) {
        System.out.println("Wrong XML file structure: " + e.getMessage());
        return null;
    } catch (IOException e) {
        System.out.println("I/O exeption: " + e.getMessage());
        return null;
    }

    return doc;

}


/** Returns element value
  * @param elem element (it is XML tag)
  * @return Element value otherwise empty String
  */
 public final static String getElementValue( Node elem ) {
     Node kid;
     if( elem != null){
         if (elem.hasChildNodes()){
             for( kid = elem.getFirstChild(); kid != null; kid = kid.getNextSibling() ){
                 if( kid.getNodeType() == Node.TEXT_NODE  ){
                     return kid.getNodeValue();
                 }
             }
         }
     }
     return "";
 }

    public static String getTopNewsXML(){    
        String line = null;

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("url");

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            line = EntityUtils.toString(httpEntity);

        } catch (UnsupportedEncodingException e) {
            line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
        } catch (MalformedURLException e) {
            line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
        } catch (IOException e) {
            line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
        }
        String st= ParseXMLNode(line,"doc");
        return st;

    }

public static String ParseXMLNode(String str,String node){
     String xmlRecords = str;
     String results = "";
     String[] result = new String [10];
     StringBuffer sb = new StringBuffer();
     try {
         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         DocumentBuilder db = dbf.newDocumentBuilder();
         InputSource is = new InputSource();
         is.setCharacterStream(new StringReader(xmlRecords));
         Document doc = db.parse(is);
         NodeList nlist = doc.getElementsByTagName(node);

         sb.append("<results count=");
         sb.append("\"10\"");
         sb.append(">\r\n");


         for (int i = 0; i < nlist.getLength(); i++) {
                Node node1 = nlist.item(i);
                if (node1.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node1;
                    NodeList nodelist = element.getElementsByTagName("str");
                    Element element1 = (Element) nodelist.item(0);
                    NodeList title = element1.getChildNodes();

                    System.out.print((title.item(0)).getNodeValue());
                    sb.append("<result>\r\n");
                        sb.append("<title>");
                            sb.append(title.item(0).getNodeValue().trim());
                        sb.append("</title>\r\n");

                    sb.append("</result>\r\n");
                    result[i] = title.item(0).getNodeValue();

                   }
            }
         sb.append("</results>");
     } catch (Exception e) {
         System.out.println("Exception........"+results );
         e.printStackTrace();
     }
     return sb.toString();
     }
}

public static int numResults(Document doc) {
    Node results = doc.getDocumentElement();
    int res = -1;
    try {
        res = Integer.valueOf(results.getAttributes().getNamedItem("count")
                .getNodeValue());
    } catch (Exception e) {
        res = -1;
    }
    return res;
}

public static String getValue(Element item, String str) {
    NodeList n = item.getElementsByTagName(str);
    return XMLfunctions.getElementValue(n.item(0));
}