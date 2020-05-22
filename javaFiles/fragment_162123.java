@Bean
    public IntegrationFlow mqttInFlow() {
        return IntegrationFlows.from(mqttInbound())
                .transform(p -> p)
                .handle("myService","handleHere")
                .handle(logger())
                .get();
    }

@Component
public class MyService {

    @ServiceActivator
    public Object handleHere(@Payload Object mess) {
        System.out.println("payload "+mess);
        return mess;
    }
}