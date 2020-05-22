@MTOM
@WebService(name = "sampleService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED)
public class SampleServiceEndpoint extends SpringBeanAutowiringSupport {

    @Autowired
    LookupService lookupService;

    @Autowired
    PersistenceService persistenceService;

    @WebMethod(exclude=true)
    private void initLookupService(){
        if(lookupService == null)
            processInjectionBasedOnCurrentContext(this);
    }

    @WebMethod(exclude=true)
    private void initPersistenceService(){
        if(persistenceService == null)
            processInjectionBasedOnCurrentContext(this);
    }

    @WebMethod
    public List<Items> getItems() {
        initLookupService();
        return lookupService.getItems();
    }

    @WebMethod
    public long updateItem(@WebParam(name = "item") Item item) throws ConcurrencyException{
        initPersistenceService()
        return persistenceService.updateItem(item);
    }

    @XmlMimeType("application/octet-stream")
    @WebMethod
    public DataHandler downloadFaxFile(String filename){
        return  new DataHandler(new FileDataSource(filename));
    }
}