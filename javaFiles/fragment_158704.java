public class ParameterHandler extends DefaultHandler {
 private Data data = null;
 private StringBuilder contentsOfTheCurrentTag=null;
 private Parameter parameter = null;

 public ParameterHandler(){
        contentsOfTheCurrentTag =new StringBuilder();
    }

    public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Details")) {
            data=new Data();            
        }
        if (qName.equalsIgnoreCase("Parameter")) {
            parameter=new Parameter();          
        }


    }

    public void endElement(String uri, String localName,
        String qName) throws SAXException {
        System.out.println("End Element :" + qName);
        int length = contentsOfTheCurrentTag.length();
        if (qName.equalsIgnoreCase("name")) {
            parameter.setName(contentsOfTheCurrentTag.toString().trim());
        }

        if (qName.equalsIgnoreCase("value")) {
            parameter.setValue(contentsOfTheCurrentTag.toString().trim());
        }

        if (qName.equalsIgnoreCase("parameter")) {
            if("id".equals(parameter.getName())){
                data.setId(parameter.getValue())
            }
            else if("requester".equals(parameter.getName())){
                data.setRequester(parameter.getValue())
            }
            .
            .so On...
        }
        contentsOfTheCurrentTag.delete(0,length);

    }

    public void characters(char ch[], int start, int length) throws SAXException {
         contentsOfTheCurrentTag.append(ch, start, length); 
    }



    //Add getter setter for data
}



public class ReadXMLFile {

   public static void main(String argv[]) {

    try {

    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser saxParser = factory.newSAXParser();
    PremiumHandler handler= new PremiumHandler();
    saxParser.parse("c:\\file.xml", handler);
    Data data=handler.getData();

     } catch (Exception e) {
       e.printStackTrace();
     }
 }
}