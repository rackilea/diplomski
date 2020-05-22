@SpringBootApplication
@EnableBinding(Sink.class)
public class So43661064Application {

    public static void main(String[] args) {
        SpringApplication.run(So43661064Application.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void foo1(String in) {
        System.out.println(in);
    }

}