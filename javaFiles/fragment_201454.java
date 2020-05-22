@Test
public void testMockedInClass() {
    System.out.println("Mocked in helper class");
    setupMocks();
    ClassA a = new ClassA();
    a.methodA();

}

}