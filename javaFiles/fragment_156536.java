@Configuration
@Import(AConfig.class)
public class BConfig {  

    @Autowired
    private A a;

    @Bean
    public B b() {
        B b = new B();
        b.setA(a);
        return b;
    }
}