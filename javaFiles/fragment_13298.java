public class TieHornetqLookup {
//  private static final Log log = LogFactory.getLog(CreateOrderLookup.class.getName());
    private String request;
    private TieHornetqResponse response;

    public TieHornetqLookup(String request) {
        this.request = request;
    }

    public TieHornetqResponse getResponse() throws Exception {

        try{

            SendRequest.sender(request);

            return response;
        } catch(Exception e) {
            //log.error("Exception while attempting to get a response: ", e);
            throw e;
        }
    }
}