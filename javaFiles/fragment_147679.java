OutputStream os = new ByteArrayOutputStream();
JAXBContext jc = JAXBContext.newInstance(SomeClass.class);
Marshaller m = jc.createMarshaller();
m.marshal(input, os);
String xml = os.toString();
logger.debug(xml);