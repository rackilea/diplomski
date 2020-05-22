@Component("criptoClient")
@ConditionalOnProperty(
      name = "enabled.client", 
      havingValue = "first")
public class FierstClient implements CryptoClient {
}

@Component("criptoClient")
@ConditionalOnProperty(
      name = "enabled.client",
      havingValue = "second")
public class SecondClient implements CryptoClient {
}