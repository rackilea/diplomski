public class XMLHandler extends DefaultHandler {

   private int counter = 0;

   @Override
   public void startElement(String uri, String localName, String qName,
                                       Attributes attributes) throws SAXException {

      if (counter < 20) {
            ...
      } else {
         return;
      }
    }

   @Override
   public void endElement(String uri, String localName, String qName)
                                                    throws SAXException {
      counter++;
      ....
   }
   ...
}