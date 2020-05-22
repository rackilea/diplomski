JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
Marshaller marshaller = jaxbContext.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

StringWriter writer = new StringWriter();
marshaller.marshal(customer, writer);

String xml = writer.toString();