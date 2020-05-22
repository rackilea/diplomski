String xml = new String(Files.readAllBytes(Paths.get("C:\\test\\file.xml")),
         StandardCharsets.UTF_8);
xml = "<?xml version=\"1.0\">\n" + xml;
xml = xml.replace("<short_desc>", "<short_desc><![CDATA[");
xml = xml.replace("</short_desc>", "]]></short_desc>");
jaxbUnmarshaller.unmarshal(new StreamSource(new StringReader(xml)));