public static class HasExpectedException {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void throwsNullPointerException() {
            thrown.expect(NullPointerException.class);
            throw new NullPointerException();
    }
}