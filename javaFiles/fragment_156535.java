@Configuration
public class BConfig {  

    @Autowired
    private AConfig aConfig;

    @Bean
    public B b() {
        B b = new B();
        b.setA(aConfig.a());
        return b;
    }
}