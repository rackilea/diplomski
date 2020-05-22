@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceInterface {

    @WebMethod
    String[] listSample();
}