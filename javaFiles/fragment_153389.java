@Configuration
public class ApplicationConfiguration {

    @Bean
    Foo createFooBean() {
      return new Foo(createMyClassBean());
    }

    @Bean
    MyClass createMyClassBean() {
      return new MyClass();
    }

}