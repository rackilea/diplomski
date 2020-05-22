@ManagedBean
@RequestScoped
public class Database {

    public Database() {
        // Put code here which is to be executed when the bean is constructed.
    }

    @PostConstruct
    public void init() {
        // Or here, if you depend on injected dependencies like EJBs and so on.
    }

    // ...
}