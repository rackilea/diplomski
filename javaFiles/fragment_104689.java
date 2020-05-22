@Test
public void test() throws Exception {
    ex.handleAssertionErrors();
    ex.expect(java.lang.AssertionError.class);
    myMethod(Arrays.asList(1, 2), Arrays.asList(1, 2, 3));
}