@RestController
@RequestMapping("/auth")
public class AuthController {

   @Autowired
   private AuthService authService;

   public AuthModel addAuthenticatable(AuthModel auth){
       //process input etc..
       return authService.save(auth);
   }
}