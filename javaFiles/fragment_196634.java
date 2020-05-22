public String transformResultXML(String xmlSource, Templates xsl,String policyXml )    {
       String result = "";  

    try {

          StringWriter writer = new StringWriter();
          StringReader reader2 = new StringReader(policyXml);

          DocumentBuilderFactory dfactory =
                  DocumentBuilderFactory.newInstance( "com.icl.saxon.om.DocumentBuilderFactoryImpl",null);

          dfactory.setNamespaceAware(true);

          DocumentBuilder docBuilder = dfactory.newDocumentBuilder();

          org.w3c.dom.Document document = docBuilder.parse(new InputSource(new StringReader(xmlSource)));

          Transformer transformer = xsl.newTransformer();

          transformer.setParameter("RsXml", document.getDocumentElement());

          transformer.setOutputProperty(OutputKeys.INDENT, "yes");
          transformer.transform(new javax.xml.transform.stream.StreamSource(reader2),
                  new javax.xml.transform.stream.StreamResult(writer));
          result = writer.toString();
          System.out.println(result);

    } catch( Exception e ) {
        e.printStackTrace();
    }