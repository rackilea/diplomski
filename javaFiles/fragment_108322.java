OutputFormat format = new OutputFormat(document); //document is an instance of org.w3c.dom.Document
format.setLineWidth(65);
format.setIndenting(true);
format.setIndent(2);
Writer out = new StringWriter();
XMLSerializer serializer = new XMLSerializer(out, format);
serializer.serialize(document);

String formattedXML = out.toString();