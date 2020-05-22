@SpringBootApplication
@EnableBinding({ Processor.class, So39018400Application.Errors.class })
public class So39018400Application {

    public static void main(String[] args) {
        SpringApplication.run(So39018400Application.class, args);
    }

    @Bean
    public Foo foo() {
        return new Foo();
    }

    public interface Errors {

        @Output("errors")
        MessageChannel errorChannel();

    }

    private static class Foo {

        @Autowired
        Source source;

        @Autowired
        Errors errors;

        @StreamListener(Processor.INPUT)
        public void handle (Message<byte[]> in) {
            try {
                source.output().send(new GenericMessage<>("foo"));
                source.output().send(new GenericMessage<>("foo"));
                throw new RuntimeException("foo");
            }
            catch (RuntimeException e) {
                errors.errorChannel().send(MessageBuilder.fromMessage(in)
                        .setHeader("foo", "bar") // add whatever you want, stack trace etc.
                        .build());
                throw e;
            }
        }

    }

}