// the XML content you gave
String xml = ...

StringReader reader = new StringReader(xml);
NewFields newFields = (NewFields) unmarshaller.unmarshal(reader);

// modify the unmarshalled data to your heart's content
newFields.empLastName = ...

// marshal the modified data anywhere you want
marshaller.marshal(newFields, System.out);