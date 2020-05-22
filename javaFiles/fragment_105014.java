@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceInterface {

    @WebMethod
    PojoSample listSample();
}