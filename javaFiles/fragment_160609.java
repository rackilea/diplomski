@Tested
private MyClassToBeTested myClassToBeTested;
@Injectable
private MockClass mockClass;

@Test
public void test() {
    // Add required expectations
    new Expectations() {{
        ...
        ..
    }};

    // Invoke the method to be tested with test values;
    String expectedA = "testValueA";
    String expectedB = "testValueB";
    boolean result = myClassToBeTested.testMethod(expectedA, expectedB);

    // Assert the return value of the method
    Assert.assertTrue(result);

    // Do the verifications and assertions
    new Verifications() {{
        String actualA;
        mockClass.mockMethod(actualA = withCapture()); times = 1;
        Assert.assertNotNull("Should not be null", actualA);
        Assert.assertEquals(actualA, expectedA);
        ...
        ..
    }};

}