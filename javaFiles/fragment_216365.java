File file = new File("D:/var/lib/tomcat7/webapps/tmpFiles/1.xml");
JAXBContext jaxbContext = JAXBContext.newInstance(CardUpdateResponseWrapper.class);
Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
CardUpdateResponseWrapper wrapper = (CardUpdateResponseWrapper) jaxbUnmarshaller.unmarshal(file);

 System.out.println(wrapper.getResponse().getResErrorMsg());