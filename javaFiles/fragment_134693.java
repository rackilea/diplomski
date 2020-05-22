@Configuration
public class AppConfig {
    @Bean(name="customer")
    public Customer getCustomer(){
        return new Customer();
    }
    @Bean
    public BeanPP getPP(){
        return new BeanPP();
    }
}