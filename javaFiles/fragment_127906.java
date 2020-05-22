XMLInputFactory f = XMLInputFactory.newInstance();
XMLStreamReader rdr = f.createXMLStreamReader(new FileReader("C:\\Users\\pramod.karandikar\\Desktop\\Test.xml"));
while (rdr.hasNext()) {
      if (rdr.next() == XMLStreamConstants.START_ELEMENT) {
          if (rdr.getLocalName().equals("PROTOCOLTAG")) {
               String txt = rdr.getElementText();
               if (txt.indexOf("SITELINK") > 0) {
                  System.out.println(txt);
                }
           }
      }
 }