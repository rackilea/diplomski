JAXBContext jc = JAXBContext.newInstance(Employee.class);

Unmarshaller unmarshaller = jc.createUnmarshaller();
Employee employee = (Employee) unmarshaller.unmarshal(xml);

Marshaller marshaller = jc.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
marshaller.marshal(employee, System.out);