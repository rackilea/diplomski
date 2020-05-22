try {
  SchemaFactory sf = ....

  Schema schema = sf.newSchema(...)    // SAXException has to be handled
  Validator validator = ...

  validator.validate(xmlFile);   // IOException has to be handled again
} catch (SAXException e) {
    // handle SAX error
} catch (IOException e) {
    // handle IO error
}