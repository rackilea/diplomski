@Bean
public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory, ExampleErrorHandler errorHandler) {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setErrorHandler(errorHandler);
    return factory;
}

@Service
public class ExampleErrorHandler implements ErrorHandler{   
    @Override
    public void handleError(Throwable t) {
        //handle exception here
    }
}