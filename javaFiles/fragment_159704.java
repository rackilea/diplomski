@WebServiceClient(name = "TicketWSImplService", targetNamespace =    "http://ticket.example.com/", wsdlLocation = "http://localhost:8080/ticket?wsdl")
@HandlerChain(file = "handler-chain.xml")
public class TicketWSImplService extends Service {

@WebMethod
public void method(){

}