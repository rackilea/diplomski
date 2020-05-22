public void startElement(String uri, String localName, 
                 String qName, Attributes attrs) throws SAXException 
         {
             if(qName.equalsIgnoreCase("Relationship"))
             {
                 .....
             }
             else if (qName.equalsIgnoreCase("Relationships") {
                  // do nothing
             }
             else 
             {
                 throw new IllegalArgumentException("Element '" + 
                         qName + "' is not allowed here");
             }
         }