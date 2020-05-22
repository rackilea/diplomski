public class ResponseTest {
    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Response.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        Response response = new Response();
        marshaller.marshal(response, System.out);
    }
}