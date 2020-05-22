@Test
public void testStuff() {
    ee.expect(IllegalArgumentException.class);
    ee.expectMessage(containsString("error"));
    ee.expect(hasProperty("errorCode", is(7)));
}