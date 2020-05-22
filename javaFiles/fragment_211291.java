@Configuration
@ComponentScan({"ar.edu.itba.paw"})
@EnableTransactionManagement(mode = AdviceMode.PROXY)
public class WebConfig {
    // code
}