@Bean
public MainPrototypeBean mainPrototypeBean() {
    Shared shared = new Shared();
    First first = new First(shared);
    Second second = new Second(shared);
    return new MainPrototypeBean(first, second);
}