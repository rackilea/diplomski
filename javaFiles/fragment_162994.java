@WebService(name = "abc", targetNamespace = "xyz", wsdlLocation="/path to wsdl")
@EndpointProperties(value = {
    @EndpointProperty(key="schema-validation-enabled", value="true")
})
public interface MyFirstSOAPWebService{
    @WebMethod(action = "create")
    VoidResponse create(    
                            @WebParam(name="description") @XmlElement(required=true) String description, 
                            @WebParam(name="userId") @XmlElement(required=true) String userId, 
                            @WebParam(name="accountImage") String accountImage...);
}