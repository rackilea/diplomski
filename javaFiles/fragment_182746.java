@Configuration
 public class TestConfiguration {

@Bean(name = "publishJNDITemplate")
public JndiTemplate publishJNDITemplate() {
    final Properties environment = new Properties();
    environment.put(Context.INITIAL_CONTEXT_FACTORY, factoryIntial);
    environment.put(Context.PROVIDER_URL, providerUrl);
    environment.put(Context.SECURITY_PRINCIPAL, securityPrincipal);
    environment.put(Context.SECURITY_CREDENTIALS, securityCredentials);
    environment.put(narfeedTopics, destination);
    return new JndiTemplate(environment);
}