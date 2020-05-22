@Configuration
public class AConfig {  
    @Bean
    public A a() {
        return new A();
    }

    @Bean
    public B b() {
        B b = new B();
        b.setA(a());
        return b;
    }
}