String xslt = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                    "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">" +
                    "<xsl:output method=\"xml\" omit-xml-declaration=\"yes\"/>" +
                    "<xsl:template match=\"/\">" +
                    "<xsl:copy-of select=\"//foo/foo2/another1\"/>" +
                    "</xsl:template>" +
                    "</xsl:stylesheet>";



Transformer transformer = TransformerFactory.newInstance().newTransformer( new StreamSource(new StringReader(xslt)) );
StreamSource xmlSource = new StreamSource( new File( "anotherfoo.xml" ) );
StringWriter sw = new StringWriter();
transformer.transform(xmlSource, new StreamResult(sw) );

System.out.println(sw.toString());