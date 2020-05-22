ObjectFactory f = new ObjectFactory();
JAXBContext context = JAXBContext.newInstance("xsd.test");
Unmarshaller unmarshaller = context.createUnmarshaller();
String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ns2:teste xmlns:ns2=\"xsd.test\"><date>2016-01-01T00:00+01:00</date></ns2:teste>";
JAXBElement<Teste> jaxElement = unmarshaller.unmarshal(new StreamSource(new ByteArrayInputStream(xml.getBytes())), Teste.class);
OffsetDateTime odt = jaxElement.getValue().getDate();
System.out.println(odt); // 2016-01-01T00:00+01:00