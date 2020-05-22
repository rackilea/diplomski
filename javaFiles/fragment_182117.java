public class JaxbTest {

    @Test
    public void testObjectToXml() throws JAXBException {
        RequestXml requestXml = new RequestXml();
        requestXml.setContact(new Contact[]{new Contact("aaa", "bbb")});
        JAXBContext jaxbContext = JAXBContext.newInstance(RequestXml.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(requestXml, System.out);
    }
}