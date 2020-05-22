public void startElement(String uri, String localName, 
                 String qName, Attributes attrs) throws SAXException 
         {
             if(localName.equalsIgnoreCase("Relationship"))
             {
                 .....
             }  
             else 
             {
                 throw new IllegalArgumentException("Element '" + 
                         qName + "' is not allowed here");
             }
         }