JAXBContext jc = JAXBContext.newInstance(Employee.class);

Unmarshaller unmarshaller = jc.createUnmarshaller();
JAXBElement<Employee> je = unmarshaller.unmarshal(xml, Employee.class);
Employee employee = je.getValue();

Marshaller marshaller = jc.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
marshaller.marshal(je, System.out);