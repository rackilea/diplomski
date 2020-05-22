@Test
void testFoo() {
    boolean fooHasThrownException = false;
    boolean barHasThrownException = false;
    boolean gbrHasThrownException = false;

    try {
        ClassFoo.foo(null);
        fail();
    } catch (AssertionError e) {
        fooHasThrownException = true;
    }

    try {
        ClassBar.bar(null);
        fail();
    } catch (AssertionError e) {
        barHasThrownException = true;
    }

    try {
        ClassGbr.gbr(null);
        fail();
    } catch (AssertionError e) {
        gbrHasThrownException = true;
    }

    assertThat(true, equalTo(fooHasThrownException),
                     equalTo(barHasThrownException),
                     equalTo(gbrHasThrownException));
}