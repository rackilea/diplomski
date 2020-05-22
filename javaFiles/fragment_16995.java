@Test public static void testIt() {
    try {
        foobar(); // throws an IOException
    } catch (Exception e) {
        fail("caught an exception " + e.getMessage());
    }
}