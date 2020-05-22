@SpringBootApplication
@EnableBinding(TwoInputs.class)
public class So43661064Application {

    public static void main(String[] args) {
        SpringApplication.run(So43661064Application.class, args);
    }

    @StreamListener("input1")
    public void foo1(String in) {
        doFoo(in);
    }

    @StreamListener("input2")
    public void foo2(String in) {
        doFoo(in);
    }

    protected void doFoo(String in) {
        System.out.println(in);
    }

    public interface TwoInputs {

        @Input("input1")
        SubscribableChannel input1();

        @Input("input2")
        SubscribableChannel input2();

    }

}