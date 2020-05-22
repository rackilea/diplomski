@Configuration
public class Config {
    @Bean
    public HelloWorld helloWorld(HelloWorld2 helloWorld2){
        HelloWorld a = new HelloWorld(helloWorld2);
        a.setAttr1("Demo Attr1");
        return a;

    }

    @Bean
    public HelloWorld2 helloWorld2(){
        HelloWorld2 a = new HelloWorld2();
        a.setAttr2("Demo Attr2");
        return a;               
    }
}