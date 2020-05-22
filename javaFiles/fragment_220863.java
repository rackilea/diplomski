@SpringBootApplication
public class HelloFunction {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloFunction.class, args);
    }

    @Bean("hello")
    public Function<User, Greeting> hello() {
        return user -> new Greeting("Hello! Welcome, " + user.getName());
    }

    @Bean("hi")
    public Function<User, Greeting> hi() {
        return user -> new Greeting("Hi! Welcome, " + user.getName());
    }
}