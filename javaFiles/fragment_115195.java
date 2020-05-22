private static void transform(String xml) throws TransformerException {
    String xslt = "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n" +
                  "  <xsl:output omit-xml-declaration=\"yes\"/>\n" +
                  // Transform child elements of <job>
                  "  <xsl:template match=\"job/*\">\n" +
                  "    <property name=\"{local-name(.)}\"><xsl:value-of select=\".\"/></property>\n" +
                  "  </xsl:template>\n" +
                  // Remove <company>, but transform children
                  "  <xsl:template match=\"company\">\n" +
                  "    <xsl:apply-templates select=\"node()\"/>\n" +
                  "  </xsl:template>\n" +
                  // Transform child elements of <company>
                  "  <xsl:template match=\"company/*\">\n" +
                  "    <property name=\"{local-name(..)}-{local-name(.)}\"><xsl:value-of select=\".\"/></property>\n" +
                  "  </xsl:template>\n" +
                  // Copy all other content unchanged
                  "  <xsl:template match=\"@*|node()\">\n" +
                  "    <xsl:copy>\n" +
                  "      <xsl:apply-templates select=\"@*|node()\"/>\n" +
                  "    </xsl:copy>\n" +
                  "  </xsl:template>\n" +
                  "</xsl:stylesheet>\n";
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer(new StreamSource(new StringReader(xslt)));
    transformer.transform(new StreamSource(new StringReader(xml)),
                          new StreamResult(System.out));
}