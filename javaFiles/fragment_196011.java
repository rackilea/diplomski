public class SaxReader{
    public void readXML() throws Exception{
        ResultHandler oHandler                      = new ResultHandler();
        CreateParser parser                         = new CreateParser(oHandler);    
        String responseXML = "Place your XML as String HERE";
        InputSource input                                   = new InputSource(new StringReader(responseXml)); 
        input.setEncoding("UTF-8");     
        parser.parse(input);

    }
}


class ResultHandler extends DefaultHandler {
    public void startDocument (){
        System.out.println("Start document");
    }

    public void endDocument (){
        System.out.println("End document");
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes attribs)throws SAXException {
        strValue = "";
        if(null!=qName && qName.equals("ID")){
            System.out.println("Starting element <ID> : "+strValue);
        }
    }

    public void characters(char[] ch, int start, int length)throws SAXException {
        strValue += new String(ch, start, length);
        System.out.println(">>>" + strValue);//Reading the values.
    }

    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if(null!=qName && qName.equals("ID")){
            System.out.println("Ending element </ID> : "+strValue);
        }
    }
}