serializer = Xml.newSerializer();
writer = new StringWriter(); 
try { 
serializer.setOutput(writer);
serializer.startDocument("UTF-8", true); 
serializer.setPrefix(prefix, namespace); 
serializer.startTag(prefix, tagName); 
serializer.attribute(prefix, attrName, value);
serializer.endTag(prefix, tagName); 
serializer.endDocument(); 
return writer.toString();
 } catch (IOException e) {
 throw new RuntimeException(e);
 }