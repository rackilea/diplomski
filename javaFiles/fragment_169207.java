@Configuration
public class ServiceConfiguration {

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(cxf(), new HelloWorldImpl());
        endpoint.publish("/HelloWorld");
        return endpoint;
    }

    @Bean
    public SpringBus cxf() {
        return new SpringBus();
    }

}