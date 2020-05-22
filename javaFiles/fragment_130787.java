ValueFactory factory = session.getValueFactory();
InputStream is = new ByteArrayInputStream(fileContent);

Binary binary = factory.createBinary(is);
Value value = factory.createValue(binary);
n.setProperty("jcr:data", value);