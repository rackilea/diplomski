@ManagedBean(eager=true)
@ApplicationScoped
public class VersionBean {
    private String version;
    @PostConstruct
    public void init(){
        version = Version.get();
    }
}