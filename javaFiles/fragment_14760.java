@GET
@Path("/mypath")
@Produces("application/xml")
public AccountingData getCurrentAccountingData(){
    MyAPI api = MyAPI.getInstance();
    return api.getAcctData();
}