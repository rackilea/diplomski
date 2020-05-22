@Test
public void testException_1() throws Exception {
    try {
        Dummy.exec(1);
        fail();
    } catch (IndexOutOfBoundsException e) {
        errorCollector.checkThat(e.getMessage(), is("My message1"));
    }

    try {
        Dummy.exec(2);
        ...
    } ...
}