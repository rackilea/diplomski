@Configuration
public class TestConfig {

    @Bean
    public String bean2(){
        String bean = bean1("bean2");
        System.out.println("bean2: " + bean);
        return bean;
    }

    @Bean
    public String bean3(){
        String bean = bean1("bean3");
        System.out.println("bean3: " + bean);
        return bean;
    }

    @Bean
    public String bean1(@Autowired(required = false) String name){
        System.out.println("bean1 " + name);
        return name;
    }
}