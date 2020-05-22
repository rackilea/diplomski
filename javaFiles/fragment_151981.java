@SpringBootApplication
public class So55280173Application {

    public static void main(String[] args) {
        SpringApplication.run(So55280173Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> template, Foo foo) {
        return args -> {
            template.send("so55280173", "foo");
            if (foo.template == template) {
                System.out.println("they are the same");
            }
        };
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic("so55280173", 1, (short) 1);
    }

}

@Component
class Foo {

    final KafkaTemplate<String, String> template;

    @Autowired
    Foo(KafkaTemplate<String, String> template) {
        this.template = template;
    }

}