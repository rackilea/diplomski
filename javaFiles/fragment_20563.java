void method1(List<IFoobar> list)
{
    list.add(new ConcreteClassA());
}

void method2()
{
    List<ConcreteClassB> list = /* something */;
    method1(list);
    // oops! we put a ConcreteClassA inside a List<ConcreteClassB>
}