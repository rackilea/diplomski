@Service
public class MyService {
     private final String wsdl;
     private final String username;
     private final String password;
     private final String application;

     @Autowired
     public MyService(
         @Value("${Wsdl}") String wsdl,
         @Value("${UserName}") String username,
         @Value("${UserPassword}") String password,
         @Value("${Application}") String application
         ) {
         // set it to each field.
     }
}