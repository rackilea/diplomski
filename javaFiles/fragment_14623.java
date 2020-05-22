@Endpoint
public class EndpointAccountInformationInquiry {

//  private Logger logger = Logger.getLogger(EndpointAccountInformationInquiry.class);

    private static final String TARGET_NAMESPACE = "http://www.sample.com/inquiry/GetAccountInformation";

    @Autowired
    private ServiceAccountInformation service;

    @PayloadRoot(localPart = "GetAccountInformationRq", namespace = TARGET_NAMESPACE)
    public @ResponsePayload GetAccountInformationRs handleRequest(@RequestPayload GetAccountInformationRq request, MessageContext messageContext) throws JAXBException, TransformerException {

        /*****************************************************************
         * Parse the request header and body
         * Also create response body and header
         *****************************************************************/
        SaajSoapMessage soapRequest = (SaajSoapMessage) messageContext.getRequest();
        SoapHeader soapRequestHeader = soapRequest.getSoapHeader();

        SaajSoapMessage soapResponse = (SaajSoapMessage) messageContext.getResponse();
        SoapHeader soapResponseHeader = soapResponse.getSoapHeader();        

        MyHeaderClassRq myHeaderClassRq = null;
        JAXBContext jaxbContext = JAXBContext.newInstance(MyHeaderClassRq.class);
        Iterator<SoapHeaderElement> itr = reqheader.examineAllHeaderElements();
        while (itr.hasNext()) {
            SoapHeaderElement ele = itr.next();
            myHeaderClassRq = (MyHeaderClassRq)jaxbContext.createUnmarshaller().unmarshal(ele.getSource());
        }

        /*****************************************************************
         * Call the handler function
         * This handler function is asynchronous
         *****************************************************************/
        service.handleRequest(request, myHeaderClassRq);

        /*****************************************************************
         * Create response body and header
         * And send back
         *****************************************************************/
        //Response header
        MyHeaderClassRs myHeaderClassRs = new MsgHdrRs();
        //Set header values here

        //Response body
        GetAccountInformationRs response = new GetAccountInformationRs();

        /*****************************************************************
         * Send response back
         *****************************************************************/
        jaxbContext = JAXBContext.newInstance(MyHeaderClassRs.class);
        jaxbContext.createMarshaller().marshal(myHeaderClassRs, soapResponseHeader.getResult());

        return response;
    }
}