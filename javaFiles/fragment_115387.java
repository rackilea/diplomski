@RestController
@RequestMapping("/api/user")
public class UserController {
    private WebAuthenticationDetails webAuthenticationDetails;
    @GetMapping
    public Principal get(Oauth2Authentication authentication) {
         String jwtToken = ((OAuth2AuthenticationDetails) oauth2Authentication.getDetails()).getTokenValue();
        // do stuff with jwtToken
        return authentication.getPrincipal();
    }
}