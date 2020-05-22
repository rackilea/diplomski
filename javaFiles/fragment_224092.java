factory.setNamespaceAware(true);
  factory.setValidating(true);
try {
  factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
} 
catch (IllegalArgumentException x) {
  // Happens if the parser does not support JAXP 1.2
  ...
}