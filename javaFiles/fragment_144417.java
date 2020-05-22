@Configuration
public class RealInjector {
    @Bean
    public IServer createServer(){
        return new RealServer();
    }

    @Bean
    public IClient createClient(){
        return new RealClient();
    }
}