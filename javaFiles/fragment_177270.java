@RestController
public class HelloWorldRestController {

    @Autowired
    ApiService apiService;

    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public ResponseEntity<String> listAllUsers() {
        // get data from database
        VisaResponse visaResponse = apiService.visaresponse();

        // convert bean to XML
        String xmlResponse = jaxbObjectToXML(visaResponse);

        return new ResponseEntity<>(xmlResponse, HttpStatus.OK);
    }

    private static String jaxbObjectToXML(VisaResponse customer) {
        String xmlString = "";
        try {
            JAXBContext context = JAXBContext.newInstance(VisaResponse.class);
            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            m.marshal(customer, sw);
            xmlString = sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlString;
    }
}