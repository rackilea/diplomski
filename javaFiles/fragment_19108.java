public Integer PunctToMM(String Punct) {

     long size = Integer.parseInt(Punct);
     size = Math.round(0.3528 * size / 20);
     int value = (int) size;
     return value;

 }

    public void startElement(String uri, String localName,
         String qName, Attributes attributes) throws SAXException {

         switch (qName) {
         case "w:pgSz":

             attributesVAL = attributes.getValue("w:w");
             System.out.println("width page " + PunctToMM(attributesVAL) + " mm.");

             attributesVAL = attributes.getValue("w:h");
             System.out.println("height page " + PunctToMM(attributesVAL) + " mm.");

             attributesVAL = attributes.getValue("w:code");
             if (attributesVAL == "9") {
                 attributesVAL = "A4";
             } else attributesVAL = "NO A4";
             System.out.println("format page " + attributesVAL);

             break;

         case "w:pgMar":

             attributesVAL = attributes.getValue("w:top");
             System.out.println("top margin " + PunctToMM(attributesVAL) + " mm.");

             attributesVAL = attributes.getValue("w:right");
             System.out.println("right margin " + PunctToMM(attributesVAL) + " mm.");

             attributesVAL = attributes.getValue("w:bottom");
             System.out.println("bottom margin " + PunctToMM(attributesVAL) + " mm.");

             attributesVAL = attributes.getValue("w:left");
             System.out.println("left margin " + PunctToMM(attributesVAL) + " mm.");

             break;

         default:
             break;
     }

 }