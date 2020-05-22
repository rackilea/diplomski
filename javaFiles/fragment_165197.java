@WebService
@SOAPBinding(style = Style.RPC)

    public interface HelloWorld{

        @WebMethod 
        String getString(String name);

    }