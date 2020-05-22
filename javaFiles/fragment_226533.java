@Test
public void exampleTestThatVerifiesConstructorCall(@Mocked FileInputStream anyFIS)
{
    new MyClass().doSomething();

    new Verifications() {{ new FileInputStream("someFile.txt"); }};
}