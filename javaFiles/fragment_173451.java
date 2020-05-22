@javax.jws.WebService(... ... ... )
public class MyWebService implements IMyWebService
{
    @Resource <-- <-- <-- **Dependency Injected by Spring**
    IXyzService createService;


    @PostConstruct
    public void postConstruct(){
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    public CreateResponse create(CreateRequest request)
    {
        return createService.serve(request)
    }
}