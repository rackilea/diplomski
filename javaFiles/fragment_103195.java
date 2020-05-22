File file = new File("your xml file");
    JAXBContext jaxbContext = JAXBContext.newInstance(hdb.class);

    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    HDB hdb = (HDB) jaxbUnmarshaller.unmarshal(file);
    System.out.println(hdb);