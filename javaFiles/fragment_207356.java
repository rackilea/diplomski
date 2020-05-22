@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final String AT_DOMAIN_COM = "@domain.com";

    private static final String SINGLE_SPACE = " ";

    @Value("${ldap.url.for.server1}")
    private String ldapUrlForServer1; // url set in application.properties

    @Value("${ldap.url.for.server2}")
    private String ldapUrlForServer2;

    @Value("${ldap.url.for.server3}")
    private String ldapUrlForServer3;

    @Value("${ldap.jndi.context.factory}")
    private String ldapContextFactory;

    @Value("${ldap.authentication.type}")
    private String ldapAuthenticationType; // auth type is "simple"

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {

        String username = auth.getName();
        String password = auth.getCredentials().toString();

        if (isLdapRegisteredUser(username, password)) {
            // use the credentials and authenticate against a third-party system
            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
        } else {
            return null;
        }

    }

    boolean isLdapRegisteredUser(String username, String password) {

        boolean result = false;
        Hashtable<String, String> env = new Hashtable<>();
        LdapContext ctx = null;

        try {

            env.put(Context.INITIAL_CONTEXT_FACTORY, ldapContextFactory);
            env.put(Context.SECURITY_AUTHENTICATION, ldapAuthenticationType);
            env.put(Context.SECURITY_PRINCIPAL, username + AT_DOMAIN_COM);
            env.put(Context.SECURITY_CREDENTIALS, password);
            // here I'm checking for 3 different LDAP servers
            env.put(Context.PROVIDER_URL,  ldapUrlForServer1 + SINGLE_SPACE + ldapUrlForServer2 + SINGLE_SPACE + ldapUrlForServer3); 

            ctx = new InitialLdapContext(env, null);

            if (ctx != null) {
                result = true;
                String selectedLdapUrl = ctx.getEnvironment().get(Context.PROVIDER_URL).toString();
                // do further operations with "ctx" if needed
                System.out.println("selected LDAP url is: " + selectedLdapUrl);
                System.out.println("Connection Successful!");
            }

        } catch(NamingException nex) {
            nex.printStackTrace();
        } finally {
            if (ctx != null) {
                try {
                    ctx.close();
                } catch (Exception ex) {
                }
            }
        }

        return result;

    }


    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }

}