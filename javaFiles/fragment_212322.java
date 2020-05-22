@WebService
public interface Transaction {
    @WebMethod(action="createPurchase", operationName = "purchase")
    @WebResult(name="ResultDto")
    ResultDto purchase(String partyId, String dealId); 
 }