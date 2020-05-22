@ManagedBean(name = "dataProviderBean")
public class DataProviderBean {
    @EJB
    private ContextProviderBean ctxProvider;

    public DataProviderBean() {
        super();
        ctxProvider = new ContextProviderBean();
    }
//...
}