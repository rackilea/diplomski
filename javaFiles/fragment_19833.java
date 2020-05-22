public class ClassToBeTestedTest
{
    @Tested ClassToBeTested classUnderTest;
    @Injectable ISomeInterface mockSomeInterface;

    @Test
    public void exampleTest() {
        new Expectations() {{
            mockSomeInterface.doSomething(anyString, anyString); result = "mock data";
        }};

        // call the classUnderTest
    }
}