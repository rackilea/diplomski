DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
factory.setValidating(false); // turns off validation
factory.setSchema(null);      // turns off use of schema
                              // but that's *still* not enough!
builder = factory.newDocumentBuilder();
builder.setEntityResolver(new NullEntityResolver()); // swap in a dummy resolver
return builder().parse(xmlFile);