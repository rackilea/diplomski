@Service
public class AuthenticationService {

    private IAuthentication auth;

    @PostConstruct
    protected void init() {
        boolean useDb = ...;   //got from db
        this.auth = ...; //choose correct one
    }
    public boolean authenticate(...) {        
        return auth.authenticate(...);
    }
}