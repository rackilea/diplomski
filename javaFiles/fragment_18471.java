File file = Paths.get("src/main/resources/customer.xml").toFile();
    JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    Customer customer1 = (Customer) jaxbUnmarshaller.unmarshal(file);
    customer1.setName(newName);

    // overriding toString
    System.out.println("Customer details with toString: " + customer1.toString());

    // print it nicely using JAXB
    final Marshaller marshaller = jaxbContext.createMarshaller();
    StringWriter sw = new StringWriter();
    marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    marshaller.marshal(customer1, sw);
    String xmlString = sw.toString();
    System.out.println("Customer details with JAXB.marshal: \n" + xmlString);