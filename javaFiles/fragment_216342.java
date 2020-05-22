@Configuration
public class Config {

    @Value("avalue")
    private String s;

    @Bean(name = "myClass")
    public MyClass getMyClass(){
        return new MyClass(getMyOtherClass());
    }
    @Bean(name = "myOtherClass")
    public MyOtherClass getMyOtherClass() {
        return new MyOtherClass(s);
    }
}