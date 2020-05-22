@Test
public void testMe() {
    try {
        Integer.parseInt("foobar");
        fail("expected Exception here");
    } catch (Exception e) {
        // OK
    }
}