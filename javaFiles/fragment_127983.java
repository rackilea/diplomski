JAXBContext jaxbContext  = JAXBContext.newInstance(AuthorizeRequest.class);
   Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
   jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE); //remove header
   AuthorizeRequest authorizeRequest = new AuthorizeRequest();
   authorizeRequest.setMerchantAccountId("123123");
   //jaxbMarshaller.marshal(authorizeRequest,System.out); //print to console