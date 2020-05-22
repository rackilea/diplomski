@Stateless(name="FooService1")
public class FooService1 implements FooService { }

@Stateless(name="FooService2")
public class FooService2 implements FooService { }

public class SomeClass {
   @EJB(beanName="FooService1") 
   private FooService fooService;
}