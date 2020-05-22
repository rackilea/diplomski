@Bean
public SomeService service() {
    return new SomeServiceImpl();
}

@Bean
public RabbitOperations rabbitTemplate() {
    return mock(RabbitOperations.class);
}