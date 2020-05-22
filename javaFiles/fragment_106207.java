Path xmlPath = Paths.get("1.xml");
byte[] bytes = Files.readAllBytes(xmpPath);
String xml = new String(bytes, StandardCharSets.ISO_8859_1);
xml = xml.replaceAll("^\\s*<(\w+)[^>]*>[^<]+$", "$0</$1>");
StringReader stringReader = new StringReader(xml);
XMLEventReader reader = factory.createXMLEventReader(stringReader);