@Configuration
@EnableWebSecurity
@ImportResource({"classpath*:spring-security-RSA.xml"})
public class SecurityRSAStrategyConfiguration {
    ...
}