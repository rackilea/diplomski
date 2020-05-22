@EnableIntegration
@Configuration
public class So39708474Application {

    @Bean
    public DirectChannel input() {
        return new DirectChannel();
    }

    @Bean
    public DirectChannel output() {
        return new DirectChannel();
    }

    @Bean
    public Foo foo() {
        return new Foo();
    }

    public static class Foo {

        @ServiceActivator(inputChannel = "input", outputChannel = "output")
        public Collection<Message<?>> handle(Message<?> in) {
            List<Message<?>> messages = new ArrayList<Message<?>>();
            messages.add(new GenericMessage<>("foo"));
            messages.add(new GenericMessage<>("bar"));
            return messages;
        }

    }

}