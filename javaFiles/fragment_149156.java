public class MyClass {

    @DataProvider(name = "my-data-provider")
    private Object [][] myProvider() {
        // ...
    }

    @Test
    public void testDataProviders() {
        Assert.assertTrue(myProvider().length > 0);
    }

    @Test
    // ... Real tests.

}