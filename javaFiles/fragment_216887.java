@Configuration
public class MyConf {
    ...
    @Bean
    private foo() {
        return new Foo<ClassName>(ClassName.class);
    }
    ...
}