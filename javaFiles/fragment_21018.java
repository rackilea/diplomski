@ApplicationScoped
public class MyClass {

  @Inject
  Instance<MyBean> myBeanInstance;

  public void myMethod() {
    //...
    MyBean bean = myBeanInstance.get();
    // Do stuff with bean
    myBeanInstance.destroy(bean); //Release the bean otherwise it will hold memory
  }
}