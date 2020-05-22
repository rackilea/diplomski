@Configuration
public class RibbonConfiguration{
@Bean
public IRule ribbonRule() {
    return new BestAvailableRule();
}

@Bean
public IPing ribbonPing() {
    return new PingUrl();
}