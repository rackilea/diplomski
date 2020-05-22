@BeforeClass
public void before() {
    //blah blah precondition goes here
}

@Test(priority=0)
public void start() {
    // testy test 0 goes here
}

@Test(dependsOnMethods = "start")
public void next() {
    Sysout(doSomething());
}

public String doSomething() {
    return "Helper method which I call in some test method";
}