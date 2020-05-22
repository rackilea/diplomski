@Bean(name="withType")
public MessageConsumer messageConsumerWithType(){
    return new MessageConsumer(this.channel(), "Some String");
}
@Bean(name="withoutType")
public MessageConsumer messageConsumerWithType(){
    return new MessageConsumer(this.channel());
}