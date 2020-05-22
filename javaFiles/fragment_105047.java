@Component
public class ServerPortCustomizer 
  implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Value("${billing.engine.port}")
    private String SERVERPORTNO;
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(SERVERPORTNO);
    }
}