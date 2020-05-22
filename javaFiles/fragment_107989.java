JAXBContext jaxbContext = JAXBContext.newInstance(PDXIReq.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
    // output pretty printed
    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    jaxbMarshaller.setProperty("com.sun.xml.internal.bind.xmlHeaders", 
  "\n<!DOCTYPE Example SYSTEM  \"example.dtd\">");