@Service
public class AuthenticationService {

    @Autowired
    private ApplicationContext сontext;

    public boolean authenticate(...) { 
        boolean useDb = ...;   //got from db
        IAuthentication auth = context.getBean(useDb ? DbAuthentication.class : LdapAuthentication.class);       
        return auth.authenticate(...);
    }
}