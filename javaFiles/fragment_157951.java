public class AddHttpHeaderInterceptor implements ClientInterceptor {

public boolean handleFault(MessageContext messageContext)
        throws WebServiceClientException {
    return true;
}

public boolean handleRequest(MessageContext messageContext)
        throws WebServiceClientException {
     TransportContext context = TransportContextHolder.getTransportContext();
     HttpComponentsConnection connection =(HttpComponentsConnection) context.getConnection();
     connection.addRequestHeader("name", "suman");

    return true;
}

public boolean handleResponse(MessageContext messageContext)
        throws WebServiceClientException {
    return true;
}

}