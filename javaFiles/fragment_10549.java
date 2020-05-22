@Configuration
@EnableWebMvc
public class Config{
    @Bean
    @Scope("session")
    public A a(){
        return new A();
    }
}