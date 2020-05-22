@Configuration
public class BeanConfig {
    @Bean
    public MessageConsumer messageConsumer(){
        return new MessageConsumer(this.channel());
    }
    @Bean
    public Channel channel(){
        return new Channel();
    }
}