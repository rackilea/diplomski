public abstract class DefaultRequestHandler {
    protected ServiceProvider response;
    protected  ServiceProvider request;

    public final ServiceProviderTxn getResponse() {
       ServiceProviderTxn responseTxn = doGetResponse();
       save(request,responseTxn);
       return responseTxn;
    }

    protected abstract ServiceProviderTxn deGetResponse();

    public void save(ServiceProviderTxn request, ServiceProviderTxn response){
        persistenceService.save(request, response);
    }

}