@Configuration
public class ClientConfig {

    @Bean(name="criptoClient")
    @ConditionalOnProperty(
      name = "enabled.client", 
      havingValue = "first")
    public CryptoClient firstClient() {
        // return first client
    }

    @Bean(name="criptoClient")
    @ConditionalOnProperty(
      name = "enabled.client",
      havingValue = "second")
    public CryptoClient secondClient() {
        // return second client
    }

    @Bean(name="criptoClient")
    @ConditionalOnProperty(
      name = "enabled.client", 
      matchIfMissing = true)
    public CryptoClient defaultClient() {
        // return default client
    }
}