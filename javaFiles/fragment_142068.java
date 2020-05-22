@Configuration
public class BeanConfiguration {

    @Bean
    @Lazy
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Player player(String name) {
        return new Player(name, shoes());
    }

    @Bean
    @Lazy
    public Shoes shoes() {
        return new Shoes("Adidas");
    }
}