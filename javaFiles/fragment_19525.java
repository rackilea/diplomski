Customer c1 = new Customer("Robin");
Order o1 = new Order("Phone");
c1.addOrder(o1);
JAXBContext jc = JAXBContext.newInstance(Customer.class);
Marshaller marshaller = jc.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
marshaller.marshal(c1, System.out);