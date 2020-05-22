@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    private String attribute;

    public boolean isAuthenticated(String username) {
        authRepository.doSomething();
        //implementation of the logic to check if a user is authenticated.
    }

   public boolean authenticate(String username, char[] password) {
       // implementation of logic to authenticate.
       authRepository.authenticate();
   }

   public AuthModel save(AuthModel model) {
       //implementation of saving the model
   }

}