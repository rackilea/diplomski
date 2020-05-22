public class AuthController {

    private final LdapTemplate ldapTemplate;

    AuthController(MyLdapConfig config) {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl(config.getUrl());
        contextSource.setUserDn(config.getUserDn());
        contextSource.setPassword(config.getPassword());
        contextSource.afterPropertiesSet();

        ldapTemplate = new LdapTemplate(contextSource);
        ldapTemplate.setIgnorePartialResultException(true);
    }

    @PostMapping
    public ResponseEntity authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        if (authenticateUser(authenticationRequest.getUsername(), authenticationRequest.getPassword())) {
            return ResponseEntity.ok().build();
        }
        log.warn("authentication failed for {}", authenticationRequest.getUsername());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    // authenticateUser method omitted
}