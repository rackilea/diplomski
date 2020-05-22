@Configuration
public class BeanConfiguration {

    @Bean
    @Lazy
    public Shoes shoes() {
        return new Shoes("Adidas");
    }

    @Bean
    public PlayerFactoryBean playerFactoryBean(){
        PlayerFactoryBean pfb = new PlayerFactoryBean();
        pfb.setShoes(shoes());
        return pfb;
    }
}