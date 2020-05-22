@Bean
@ConditionalOnMissingGenericBean
public Container<Book> bookContainer() {
    return new Container<>(new Book());
}

@Bean
@ConditionalOnMissingGenericBean
public Container<Computer> computerContainer() {
    return new Container<>(new Computer());
}