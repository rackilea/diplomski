JAXBContext context = JAXBContext.newInstance(Person.class);
Unmarshaller unmarshaller = context.createUnmarshaller();
File file = new File("person.xml");
Person person = (Person) unmarshaller.unmarshal(file);
Marshaller marshaller = context.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
marshaller.marshal(person, System.out);