@Produces
@ProductTypeA
public ProductA getProductA(InjectionPoint injectionpoint)
{
    this.test="testD";
    System.out.println("-----------------------------");
    System.out.println("injectionpoint.getAnnotated() = "+injectionpoint.getAnnotated());
    return new ProductA(injectionpoint);
}