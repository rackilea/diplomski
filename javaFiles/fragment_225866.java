@Aspect
public class HelloMixin {
    @DeclareMixin("xxx.xxx.services.*+")
    public HelloService createHelloService(Object target) {
        return new HelloServiceImpl(target);
    }
}

public class HelloServiceImpl implements HelloService {
    private Object target;

    public HelloServiceImpl(Object target) {
        this.target = target;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello " + getNameFromTarget());
    }

    private String getNameFromTarget() {
         // call to this.target.getName()....
    } 

}