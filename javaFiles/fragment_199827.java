@Test
public void testA() {
    // Initialize
    try {
        // Except Exception here
        Assert.fail("Exception not thrown");
    } catch (IWantToCatchException ex) {
       // Assert exception is correct
    }
    // other code
}