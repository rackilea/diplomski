@Bean
Binding bindingExchangeFoo() {
    return BindingBuilder.bind(queueFoo()).to(exchange()).with("queue.foo");
}

@Bean
Binding bindingExchangeBar() {
    return BindingBuilder.bind(queueBar()).to(exchange()).with("queue.bar");
}