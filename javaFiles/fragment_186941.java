@BeforeMethod
public void setUp(Method method) {
    if (method.getName().equals("testMethod")) {
        setUp1();
    } else if (method.getName().equals("anotherTestMethod")) {
        setUp2();
    }
}

public void setUp2() {
    System.out.println("SetUp 2 is done");
}

public void setUp1() {
    System.out.println("SetUp 1 is done");
}