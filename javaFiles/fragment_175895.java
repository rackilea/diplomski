@WebService(name = "QBWebConnectorSvcSoap", targetNamespace = "http://developer.intuit.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface QBWebConnectorSvcSoap {

@WebMethod(action = "http://developer.intuit.com/authenticate")
    @WebResult(name = "authenticateResult", targetNamespace = "http://developer.intuit.com/")
    @RequestWrapper(localName = "authenticate", targetNamespace = "http://developer.intuit.com/", className = "com.cantero.quickbooks.ws.Authenticate")
    @ResponseWrapper(localName = "authenticateResponse", targetNamespace = "http://developer.intuit.com/", className = "com.cantero.quickbooks.ws.AuthenticateResponse")
    public ArrayOfString authenticate(
        @WebParam(name = "strUserName", targetNamespace = "http://developer.intuit.com/")
        String strUserName,
        @WebParam(name = "strPassword", targetNamespace = "http://developer.intuit.com/")
        String strPassword);

//same for remaining methods    
}