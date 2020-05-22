@Configuration
@EnableAutoConfiguration
public class test {

    @Bean
    public HttpInvokerProxyFactoryBean invoker() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        String serviceURL = "http://localhost:8081/rmi";
        invoker.setServiceUrl(serviceURL);
        invoker.setServiceInterface(rmiinterface.class);
        invoker.setHttpInvokerRequestExecutor(httpInvokerRequestExecutor()); //call to the bean
        return invoker;
    }

    @Bean
    public SimpleHttpInvokerRequestExecutor httpInvokerRequestExecutor() {
        return new CustomHttpInvokerRequestExecutor();
    }
}

class CustomHttpInvokerRequestExecutor extends SimpleHttpInvokerRequestExecutor {

    @Autowired
    HttpSession session;

    @Override
    protected void prepareConnection(HttpURLConnection connection, int contentLength) throws IOException {
        // adding header.
        connection.addRequestProperty("x-auth-token", session.getId());
        super.prepareConnection(connection, contentLength);
    }
}