package mypackage.myservices;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.mirth.connect.connectors.ws.AcceptMessage;
import com.mirth.connect.connectors.ws.WebServiceReceiver;

@WebService
public class QueryService extends AcceptMessage {

    public QueryService(WebServiceReceiver webServiceReceiver) {
        super(webServiceReceiver);
    }

    @WebMethod(action="Authenticate")
    public AuthResponse authenticate(@WebParam(name="Username") String username, 
        @WebParam(name="Password") String password) {
        //authenticate your user and return an AuthResponse, 
        //possibly containing a token for use in subsequent calls...

        return new AuthResponse();
    }

    @WebMethod(action="GetResponse")
    public QueryResponse getResponse(@WebParam(name="QueryObject") Query query) {
        //handle the Query object, use it to get data from a DB, or whatever

        return new QueryResponse(); // or an appropriate Response object
    }
}