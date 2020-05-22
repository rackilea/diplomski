Transformer trans = TransformerFactory.newInstance().newTransformer(
  new StreamSource(new StringReader("<?xml version='1.0'?>"
   +"<stylesheet xmlns='http://www.w3.org/1999/XSL/Transform' version='1.0'>"
   +  "<template match='*' priority='1'>"
   +    "<element name='{local-name()}'><apply-templates select='@*|node()'/></element>"
   +  "</template>"
   +  "<template match='@*' priority='0'>"
   +    "<attribute name='{local-name()}'><value-of select='.'/></attribute>"
   +  "</template>"
   +  "<template match='node()' priority='-1'>"
   +    "<copy><apply-templates select='@*|node()'/></copy>"
   +  "</template>"
   +"</stylesheet>")));
DOMResult result=new DOMResult();
trans.transform(new DOMSource(document), result);
document=(Document)result.getNode();