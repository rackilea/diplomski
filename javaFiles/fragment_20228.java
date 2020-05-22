public class SomeOtherClass {

    @EJB
    private HelloWorldService helloWorldService;

    public void doSomething() {
        System.out.println(helloWorldService.sayHello());
    }
}