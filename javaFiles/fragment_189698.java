@Bean
public A a(B b) {
    return new A(b);
}
@Bean
public B b() {
    return new B();
}