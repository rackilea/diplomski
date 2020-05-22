private static String prettyFormat(String xml) throws TransformerException, ParserConfigurationException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
     String formattedString = null;
     try {
         final InputSource src = new InputSource(new StringReader(xml));
         final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();

         // the last parameter sets indenting/pretty-printing to true:
         OutputFormat outputFormat = new OutputFormat("WHATEVER", "UTF-8", true);
         // line width = 0 means no line wrapping:
         outputFormat.setLineWidth(0);
         StringWriter sw = new StringWriter();
         XML11Serializer writer = new XML11Serializer(sw, outputFormat);
         writer.serialize((Element)document);
         formattedString = sw.toString(); 

     } catch (Exception e) {
         throw new RuntimeException(e);
     }
   return formattedString;
}