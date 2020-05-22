XMLInputFactory XMLFactory = XMLInputFactory.newInstance();
            XMLStreamReader XMLReader = XMLFactory.createXMLStreamReader(myXMLStream);
            while(XMLReader.hasNext())
            {
                if (XMLReader.getEventType() == XMLStreamReader.START_ELEMENT)
                {        
                   String XMLTag = XMLReader.getLocalName();
                   if(XMLTag.equals("value"))
                   {
                      String idValue = XMLReader.getAttributeValue(null, "id");
                      if (idValue.equals("FILE_CREATE_DATE"))
                      {
                        System.out.println(idValue);
                        XMLReader.nextTag();
                        System.out.println(XMLReader.getElementText());

                      }
                   }
               }    
               XMLReader.next();
            }