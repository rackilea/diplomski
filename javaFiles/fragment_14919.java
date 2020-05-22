@Test
public void testWhatever() {
    new Expectations() {
        AccountHelper accountHelper;
        {
            new AccountHelper();
            accountHelper.someMethod();
    }}
    objectUnderTest.doWhatever();
}