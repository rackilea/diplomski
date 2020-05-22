public void method(A a, B b, DoSomethingWithA2GStrategy strategy) {
    // Create and prepare local variables c, d, e, f, g;
    A2GParameterContainer params = new A2GParameterContainer();
    params.setA(a);
    // ...
    params.setG(g);

    strategy.doSomething(params);
    // take e, f, g from the container
    // Process e, f, g further
}