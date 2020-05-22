@RestController
public class UserRestController {

    @Autowired
    private OAuthClientConfig oAuthClientConfig;

    @PostMapping("/user")
    public OAuth2AccessToken createUserCredential(@RequestBody UserCredential user) {
        user.validate();
        userCredentialService.checkAndSaveUser(user, getClientIp(request));

        OAuth2RestOperations restTemplate = oAuthClientConfig.restTemplate();
        restTemplate.getOAuth2ClientContext().getAccessTokenRequest().set("username", user.getLogin());
        restTemplate.getOAuth2ClientContext().getAccessTokenRequest().set("password", user.getPassword);
        return restTemplate.getAccessToken();
    }
}