public interface TagListener {
    void onTagRead(<parameters>);
}

public class Controller implements TagListener {
   public Controller(){
         XMLParser parser = new XMLParser():
         parser.parseDocument(this) // pass the controller instance to get notified
   }

   public void onTagRead(<parameter>) {
        // your logic :)
   }
}

public class XMLParser {

     String type="", value="";

     public void parseDocument(TagListener listener) throws Exception{
          XMLInputFactory inputFactory = XMLInputFactory.newInstance();
          InputStream in = new FileInputStream("gaugeInput.xml");
          XMLStreamReader streamReader = inputFactory.createXMLStreamReader(in);
          streamReader.nextTag(); // Advance to "gauge_input" element
          streamReader.nextTag(); // Advance to "gauge" element

          while (streamReader.hasNext()) {
               if (streamReader.isStartElement()) {
                   switch (streamReader.getLocalName()) {
                        case "type": {
                           type = streamReader.getElementText();
                           break;
                        }
                        case "value": {
                           value = streamReader.getElementText();
                           break;
                        }
                   }
               }
               else if(streamReader.isEndElement()){
                   listener.onTagRead(...);
               }
               streamReader.next();
         }
    }
}