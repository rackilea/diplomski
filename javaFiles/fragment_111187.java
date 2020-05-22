@Test
public void test() {
DateTimeUtils.setCurrentMillisFixed(10L);
// .. your code
}

@After
public void cleanup() {
// Make sure to cleanup afterwards
DateTimeUtils.setCurrentMillisSystem()
}