@WebService(serviceName = "Prevodilac")
public class Prevodilac {

    Document doc;

    public Prevodilac() throws ParserConfigurationException, SAXException, IOException{
        // Fill the document just once, not for each method call
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE language [<!ATTLIST phrase id ID #IMPLIED>]><language id=\"sr\"><phrase key=\"house\" value=\"kuca\"/><phrase key=\"dog\" value=\"pas\"/><phrase key=\"cat\" value=\"macka\"/></language>";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xmlString));
        doc = db.parse(is);
    }

    @WebMethod(operationName = "pretraga")
    public String pretraga(String key) {
        Element r = doc.getDocumentElement();
        NodeList language = r.getElementsByTagName("phrase");
        String result = "Not found";
        for( int index = 0; index <  language.getLength(); index++ )  {
            Node attribute = language.item(index).getAttributes().getNamedItem("key");
            // TODO (It's homework after all): 
            // check if the attribute corresponds to key parameter
            if( attribute..... ){
                // fill result with attribute value
                result = ...;
            }
        }
        return result;
    }
}