@ApplicationScoped
@ManagedBean(eager=true)
public class InitializerBean {

    @PostConstruct
    public void init() {
         //init your DB here
    }

}